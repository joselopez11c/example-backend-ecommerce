package com.coderhouse.model.exceptions;

public class ApiRestException extends Exception {

    private String message;

    public ApiRestException(String message) {
        super(message);
    }

}
