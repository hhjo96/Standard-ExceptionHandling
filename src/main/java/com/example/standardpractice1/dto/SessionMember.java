package com.example.standardpractice1.dto;

import lombok.Getter;

@Getter
public class SessionMember {
    private final String name;
    private final int age;

    public SessionMember(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
