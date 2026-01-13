package com.example.standardpractice1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATE_NAME("USR-002", "이미 회원가입된 이름입니다."),
    INVALID_NAME("VAL-001", "이름 또는 나이를 확인해주세요."),
    UNDER_AGE("VAL-002", "18세 미만 또는 150세 이상인 경우 회원가입이 제한됩니다."),
    USER_LIMIT_EXCEEDED("USR-001", "가입된 회원이 10명을 초과합니다.");

    private final String code;
    private final String message;
}
