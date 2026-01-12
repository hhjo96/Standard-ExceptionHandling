package com.example.standardpractice1.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class MemberSignUpRequest {

    @NotEmpty
    @Size(min = 2, message = "이름을 확인해주세요.")
    private String name;
    @Min(value = 18, message = "18세 미만인 경우 회원가입이 제한됩니다.") @Max(value = 150, message = "나이를 확인해주세요.")
    private int age;
}
