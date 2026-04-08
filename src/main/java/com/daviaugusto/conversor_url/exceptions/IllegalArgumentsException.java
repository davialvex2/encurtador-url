package com.daviaugusto.conversor_url.exceptions;

public class IllegalArgumentsException extends RuntimeException {

    public IllegalArgumentsException(String message) {
        super(message);
    }

    public IllegalArgumentsException(String msg, Throwable tr){
        super(msg, tr);
    }
}
