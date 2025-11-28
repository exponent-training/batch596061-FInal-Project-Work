package com.IES.CM.Exception;

public class UserNotFoundThisId extends RuntimeException {

    public UserNotFoundThisId(String message) {
        super(message);
    }
}