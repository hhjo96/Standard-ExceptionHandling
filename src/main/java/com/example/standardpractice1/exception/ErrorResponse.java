package com.example.standardpractice1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private ErrorCode errorCode;
    private String message;
    private String path;
    private LocalDateTime timestamp;

    public static ErrorResponse of(HttpStatus status, ErrorCode errorCode, String message, String path) {
        return new ErrorResponse(status.value(), errorCode, message, path, LocalDateTime.now());
    }
}
