package com.luxoft.pikuza.exceptions;

public class CustomExceptions extends Exception {

    private String message;

    public CustomExceptions(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
