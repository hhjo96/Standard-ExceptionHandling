package com.example.standardpractice1.exception;


import org.springframework.http.HttpStatus;

public class MemberCountOver10Exception extends ServiceException {

    public MemberCountOver10Exception(String message) {
        super(ErrorCode.USER_LIMIT_EXCEEDED, message, HttpStatus.BAD_REQUEST);
    }
}
