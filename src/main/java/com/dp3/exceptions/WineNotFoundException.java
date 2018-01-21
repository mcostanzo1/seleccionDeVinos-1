package com.dp3.exceptions;

public class WineNotFoundException extends Exception {

    private String message;

    public WineNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
