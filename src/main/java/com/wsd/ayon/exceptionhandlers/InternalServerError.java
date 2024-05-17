package com.wsd.ayon.exceptionhandlers;

public class InternalServerError extends RuntimeException {
    public InternalServerError(String message) {
        super(message);
    }
}