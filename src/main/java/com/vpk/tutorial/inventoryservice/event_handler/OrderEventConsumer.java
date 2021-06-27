package com.vpk.tutorial.inventoryservice.event_handler;

import com.vpk.tutorial.inventoryservice.events.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    @Autowired
    InventoryEventHandler inventoryEventHandler;

    @KafkaListener(id = "orderEvent",topics = "#{'${spring.kafka.consumer.topic}'.split(',')}",containerFactory = "kafkaListenerContainerFactory")
    public void listen(OrderEvent orderEvent){
        System.out.println("Consumed: "+orderEvent);
        inventoryEventHandler.handler(orderEvent);
    }

}
