package com.example.standardpractice1.dto;

import lombok.Getter;

@Getter
public class MemberSignUpResponse {
    private final String name;

    public MemberSignUpResponse(String name) {
        this.name = name;
    }
}
