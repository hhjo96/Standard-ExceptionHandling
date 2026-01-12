package com.example.standardpractice1.controller;

import com.example.standardpractice1.dto.*;
import com.example.standardpractice1.entity.Member;
import com.example.standardpractice1.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("/api/sign-up")
    public ResponseEntity<MemberSignUpResponse> signUp(
            @Valid @RequestBody MemberSignUpRequest request) {
        return ResponseEntity.ok(memberService.signUp(request));
    }

//    //로그인
//    @PostMapping("/api/login")
//    public ResponseEntity<Void> login(
//            HttpSession session,
//            @Valid @RequestBody MemberLoginRequest request) {
//        SessionMember sessionMember = memberService.login(request);
//        session.setAttribute("loginMember", sessionMember);
//        return ResponseEntity.ok().build();
//    }

    //동일한 이름이 있는지 확인
    @GetMapping("/api/check")
    public ResponseEntity<MemberCheckResponse> check(
            @RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.check(name));
    }
}
