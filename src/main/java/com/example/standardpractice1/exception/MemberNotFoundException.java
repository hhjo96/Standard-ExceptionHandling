package com.example.standardpractice1.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends ServiceException{
    public MemberNotFoundException(String message){
        super(ErrorCode.INVALID_NAME, message, HttpStatus.NOT_FOUND);
    }
}
