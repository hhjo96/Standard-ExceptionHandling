package com.example.standardpractice1.exception;

import org.springframework.http.HttpStatus;

public class IllegalAgeException extends ServiceException{

    public IllegalAgeException(String message) {
        super(ErrorCode.INVALID_NAME, message, HttpStatus.BAD_REQUEST);
    }
}
