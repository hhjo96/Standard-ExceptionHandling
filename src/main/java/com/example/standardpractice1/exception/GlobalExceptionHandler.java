package com.example.standardpractice1.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //MemberExistsException
    @ExceptionHandler(MemberExistsException.class)
    public ResponseEntity<ErrorResponse> handleMemberExistsException(MemberExistsException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ErrorCode.DUPLICATE_NAME, ErrorCode.DUPLICATE_NAME.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MemberYoungException.class)
    public ResponseEntity<ErrorResponse> handleMemberYoungException(MemberYoungException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ErrorCode.UNDER_AGE, ErrorCode.UNDER_AGE.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MemberCountOver10Exception.class)
    public ResponseEntity<ErrorResponse> handleMemberCountOver10Exception(MemberCountOver10Exception ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ErrorCode.USER_LIMIT_EXCEEDED, ErrorCode.USER_LIMIT_EXCEEDED.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(IllegalAgeException.class)
    public ResponseEntity<ErrorResponse> handleIllegalAgeException(IllegalAgeException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_NAME, ErrorCode.INVALID_NAME.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(IllegalNameException.class)
    public ResponseEntity<ErrorResponse> handleIllegalNameException(IllegalNameException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_NAME, ErrorCode.INVALID_NAME.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }


    //extra validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String msg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_NAME, msg, request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }


    //db 조건 위배
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_NAME, ErrorCode.INVALID_NAME.getMessage(), request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }


}
