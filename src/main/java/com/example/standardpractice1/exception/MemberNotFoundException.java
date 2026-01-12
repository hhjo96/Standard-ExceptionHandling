package com.example.standardpractice1.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends ServiceException{
    public MemberNotFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}
