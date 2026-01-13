package com.example.standardpractice1.exception;

import org.springframework.http.HttpStatus;

public class MemberYoungException extends ServiceException{

    public MemberYoungException(String message){
        super(ErrorCode.UNDER_AGE, message, HttpStatus.BAD_REQUEST);
    }


}
