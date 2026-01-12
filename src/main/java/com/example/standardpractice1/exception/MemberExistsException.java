package com.example.standardpractice1.exception;

import org.springframework.http.HttpStatus;

public class MemberExistsException extends ServiceException{

    public MemberExistsException(String message){
        super(HttpStatus.CONFLICT, message);
    }
}
