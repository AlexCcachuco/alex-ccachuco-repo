package com.bosonit.block12kakfaConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics="firstTopic",
                    groupId = "groupId"
    )
    void Listener(String data){
        System.out.println(" Listener received:  "+ data + " ");
    }

}
