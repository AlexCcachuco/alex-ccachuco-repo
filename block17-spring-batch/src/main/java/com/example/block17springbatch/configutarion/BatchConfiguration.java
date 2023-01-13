package com.example.block17springbatch.configutarion;

import com.example.block17springbatch.domain.ErrorTemperatura;
import com.example.block17springbatch.domain.Tiempo;
import com.example.block17springbatch.domain.TiempoRiesgo;
import com.example.block17springbatch.error.ErrorItemProcessor;
import com.example.block17springbatch.job.TiempoItemProcessor;
import com.example.block17springbatch.job.TiempoItemReader;
import com.example.block17springbatch.job.TiempoItemWriter;
import com.example.block17springbatch.listener.TiempoItemProcessListener;
import com.example.block17springbatch.listener.TiempoItemReaderListener;
import com.example.block17springbatch.listener.TiempoItemWriterListener;
import com.example.block17springbatch.listener.TiempoJobExecutionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean
    public TiempoItemProcessor processor() {
        return new TiempoItemProcessor();
    }

    @Bean
    public TiempoItemWriter writer() {
        return new TiempoItemWriter();
    }

    @Bean
    public ItemProcessor errorProcessor(){ return new ErrorItemProcessor(); }

    @Bean
    public TiempoJobExecutionListener jobExecutionListener() {
        return new TiempoJobExecutionListener();
    }

    @Bean
    public TiempoItemReaderListener readerListener() {
        return new TiempoItemReaderListener();
    }

    @Bean
    public TiempoItemProcessListener tiempoItemProcessListener() {
        return new TiempoItemProcessListener();
    }

    @Bean
    public TiempoItemWriterListener writerListener() {
        return new TiempoItemWriterListener();
    }



    @Bean
    public FlatFileItemReader<Tiempo> reader() {
        return new FlatFileItemReaderBuilder<Tiempo>()
                .name("tiempoItemReader")
                .resource(new ClassPathResource("prueba.csv"))
                .linesToSkip(1)
                .delimited()
                .names("localidad","temperatura","fecha")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Tiempo>() {{
                    setTargetType(Tiempo.class);
                }})
                .build();
    }

    @Bean
    public FlatFileItemWriter<ErrorTemperatura> errorWriter() {
        FlatFileItemWriter<ErrorTemperatura> writer = new FlatFileItemWriter<ErrorTemperatura>();
        writer.setResource(new FileSystemResource("block17-spring-batch/src/main/resources/errors.csv"));
        writer.setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("id, Localidad, Temperatura, Fecha");
                writer.write("Localidad, Temperatura, Fecha");
            }
        });
        writer.setLineAggregator(new DelimitedLineAggregator<ErrorTemperatura>() {{
            setDelimiter(",");
            setFieldExtractor(new BeanWrapperFieldExtractor<ErrorTemperatura>(){{
                setNames(new String[]{"id", "localidad", "temperatura","fecha"});
                setNames(new String[]{"localidad", "temperatura","fecha"});
            }});
        }});
        return writer;
    }


    @Bean
    public Job job(Step step, Step step2, TiempoJobExecutionListener jobExecutionListener) {
        Job job = jobBuilderFactory.get("job1")
                .listener(jobExecutionListener)
                .flow(step)
                .next(step2)
                .end()
                .build();
        return job;
    }

    @Bean
    public Step step(
                     TiempoItemWriter writer,
                     TiempoItemProcessor processor,
                     TiempoItemReaderListener readerListener,
                     TiempoItemProcessListener tiempoItemProcessListener,
                     TiempoItemWriterListener writerListener) {

        TaskletStep step = stepBuilderFactory.get("step1")
                .<Tiempo, TiempoRiesgo>chunk(100)
                .reader(reader())
                .processor(processor)
                .writer(writer)
                .listener(readerListener)
                .listener(tiempoItemProcessListener)
                .listener(writerListener)
                .build();
        return step;
    }

    @Bean
    public Step step2(ErrorItemProcessor processor) {

        TaskletStep step = stepBuilderFactory.get("step2")
                .<Tiempo, ErrorTemperatura>chunk(100)
                .faultTolerant()
                .skipLimit(100)
                .skip(InvalidObjectException.class)
                .reader(reader())
                .processor(processor)
                .writer(errorWriter())
                .build();
        return step;
    }
}
