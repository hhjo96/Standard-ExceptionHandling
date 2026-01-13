package com.example.standardpractice1.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class MemberSignUpRequest {

    private String name;
    private int age;
}
