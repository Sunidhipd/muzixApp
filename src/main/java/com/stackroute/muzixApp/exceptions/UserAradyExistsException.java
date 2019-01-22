package com.stackroute.muzixApp.exceptions;

public class UserAradyExistsException extends Exception {

    private String message;

    public UserAradyExistsException(String message){
        super(message);
        this.message=message;
    }
}

