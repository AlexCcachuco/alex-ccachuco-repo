package com.bosonit.block12kakfaConsumer;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class KafkaListeners {

    @KafkaListener(topics="firstTopic",
                    groupId = "groupId"
    )
    void Listener(String data){
        System.out.println(" Listener received:  "+ data + " ");
        log.info("MENSAJE LLEGANDO AL LISTENER : {}", data);
    }

}
