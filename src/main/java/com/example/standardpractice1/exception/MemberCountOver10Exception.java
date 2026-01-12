package com.example.standardpractice1.exception;


import org.springframework.http.HttpStatus;

public class MemberCountOver10Exception extends ServiceException {

    public MemberCountOver10Exception(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
