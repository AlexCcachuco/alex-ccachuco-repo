package com.bosonit.block12kakfaConsumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@Log4j2
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message myMessage){
        kafkaTemplate.send("firstTopic", myMessage.message());
        log.info("MENSAJE LLEGANDO AL LISTENER : {}", myMessage);
        return myMessage;
    }

}
