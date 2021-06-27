package com.vpk.tutorial.inventoryservice.exception;

import lombok.Getter;

@Getter
public class SerializationException extends RuntimeException {

    private String exceptionMessage;

    public SerializationException(String exceptionMessage){
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public SerializationException(String exceptionMessage, Exception exception){
        super(exceptionMessage,exception);
        this.exceptionMessage = exceptionMessage;
    }
}
