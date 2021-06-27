package com.vpk.tutorial.inventoryservice.messaging.deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpk.tutorial.inventoryservice.events.OrderEvent;
import com.vpk.tutorial.inventoryservice.exception.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class OrderEventDeserializer implements Deserializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object deserialize(String s, byte[] bytes) {
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        OrderEvent orderEvent;
        try{
            orderEvent = objectMapper.readValue(bytes, OrderEvent.class);
        }catch (Exception e){
            throw new SerializationException("Exception in deserializing order event",e);
        }
        return orderEvent;
    }
}

