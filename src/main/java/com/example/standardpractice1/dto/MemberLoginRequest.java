package com.example.standardpractice1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberLoginRequest {

    @NotEmpty
    @Size(min = 2, message = "이름을 확인해주세요.")
    private String name;
}
