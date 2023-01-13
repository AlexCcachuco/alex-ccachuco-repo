package com.example.block17springbatch.job;

import com.example.block17springbatch.domain.Tiempo;
import com.example.block17springbatch.domain.TiempoRiesgo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TiempoItemProcessor implements ItemProcessor<Tiempo, TiempoRiesgo> {

    private static final Logger LOG = LoggerFactory.getLogger(TiempoItemProcessor.class);

    @Override
    public TiempoRiesgo process(Tiempo tiempo){

        if(tiempo.getTemperatura() > 50 || tiempo.getTemperatura() < -20){
            return null;
        }else {
            String riesgo;
            int temperatura = tiempo.getTemperatura();
            String[] datos = tiempo.getFecha().split("-");

            if(temperatura >= 36){
                riesgo = TiempoRiesgo.HIGH;
            } else if (temperatura > -20) {
                riesgo = TiempoRiesgo.MEDIUM;
            } else {
                riesgo = TiempoRiesgo.LOW;
            }


            TiempoRiesgo tiempoRiesgo = new TiempoRiesgo(tiempo.getLocalidad(), datos[1], datos[0], riesgo,tiempo);
            return tiempoRiesgo;
        }
    }
}
