package com.dp3.exceptions;

public class CellarNotFoundException extends Exception {

    private String message;

    public CellarNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
