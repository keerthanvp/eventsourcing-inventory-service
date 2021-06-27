package com.vpk.tutorial.inventoryservice.messaging.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpk.tutorial.inventoryservice.events.InventoryEvent;
import com.vpk.tutorial.inventoryservice.exception.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class InventoryEventSerializer implements Serializer<InventoryEvent> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, InventoryEvent inventoryEvent) {
        byte [] bytes;
        try{
            bytes = objectMapper.writeValueAsString(inventoryEvent).getBytes();
        }catch (Exception e){
            throw new SerializationException("Exception while serializing inventory event: ",e);
        }
        return bytes;
    }
}
