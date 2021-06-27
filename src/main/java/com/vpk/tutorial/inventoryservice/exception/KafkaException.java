package com.vpk.tutorial.inventoryservice.exception;

import lombok.Getter;

@Getter
public class KafkaException extends RuntimeException {

    private String exceptionMessage;

    public KafkaException(String exceptionMessage){
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public KafkaException(String exceptionMessage, Exception exception){
        super(exceptionMessage,exception);
        this.exceptionMessage = exceptionMessage;
    }
}
