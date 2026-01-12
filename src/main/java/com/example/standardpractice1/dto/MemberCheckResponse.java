package com.example.standardpractice1.dto;

import lombok.Getter;

@Getter
public class MemberCheckResponse {
    private final String message;

    public MemberCheckResponse(String message) {
        this.message = message;
    }
}
