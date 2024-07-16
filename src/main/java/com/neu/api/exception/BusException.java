package com.neu.api.exception;

import lombok.Data;

@Data
public class BusException extends RuntimeException{
    private String simpleMsg;


    public BusException(String message){
        super(message);
        this.simpleMsg = message;
    }

    public BusException(String message,String simpleMsg){
        super(message);
        this.simpleMsg = simpleMsg;
    }



}
