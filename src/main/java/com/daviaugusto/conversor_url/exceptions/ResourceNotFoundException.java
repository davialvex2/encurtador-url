package com.daviaugusto.conversor_url.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
