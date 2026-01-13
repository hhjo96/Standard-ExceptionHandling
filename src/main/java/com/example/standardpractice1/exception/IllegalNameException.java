package com.example.standardpractice1.exception;

import org.springframework.http.HttpStatus;

public class IllegalNameException extends ServiceException{

    public IllegalNameException(String message) {
        super(ErrorCode.INVALID_NAME, message, HttpStatus.BAD_REQUEST);
    }
}
