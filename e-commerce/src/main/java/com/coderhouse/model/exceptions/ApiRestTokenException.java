package com.coderhouse.model.exceptions;

public class ApiRestTokenException extends Exception {

    private String message;

    public ApiRestTokenException(String message) {
        super(message);
    }

}
