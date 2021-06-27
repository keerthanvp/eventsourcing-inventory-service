package com.vpk.tutorial.inventoryservice.event_handler;

import com.vpk.tutorial.inventoryservice.events.InventoryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventPublisher {

    @Value("${spring.kafka.producer.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, InventoryEvent> kafkaTemplate;

    public void publish(InventoryEvent inventoryEvent){
        try {
            kafkaTemplate.send(topic, inventoryEvent);
            System.out.println("Inventory Event published: "+inventoryEvent);
        }catch (Exception e){
            throw new KafkaException("Exception while publishing inventory event: ",e);
        }
    }
}
