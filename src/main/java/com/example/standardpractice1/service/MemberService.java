package com.example.standardpractice1.service;

import com.example.standardpractice1.dto.*;
import com.example.standardpractice1.entity.Member;
import com.example.standardpractice1.exception.*;
import com.example.standardpractice1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSignUpResponse signUp(MemberSignUpRequest request) {
        //가입된 회원 10명 초과하는지 체크
        long countMembers = memberRepository.count();
        if (countMembers >= 10) {
            throw new MemberCountOver10Exception(ErrorCode.USER_LIMIT_EXCEEDED.getMessage());
        }

        //나이 체크
        if(request.getAge() < 18 || request.getAge() > 150) {
            throw new MemberYoungException(ErrorCode.UNDER_AGE.getMessage());
        }

        //중복이름 체크
        if(memberRepository.existsByName(request.getName())) {
            throw new MemberExistsException(ErrorCode.DUPLICATE_NAME.getMessage());
        }

        //이름 빈칸/1글자 체크
        if(request.getName().isBlank() || request.getName().isEmpty() || request.getName().length() < 2) {
            throw new IllegalNameException(ErrorCode.INVALID_NAME.getMessage());
        }




        Member member = new Member(request.getName(), request.getAge());
        Member savedMember = memberRepository.save(member);

        return new MemberSignUpResponse(savedMember.getName());

    }

//    public SessionMember login(MemberLoginRequest request) {
//        Member member = memberRepository.findByName(request.getName()).orElseThrow(
//                () -> new MemberNotFoundException("해당 이름으로 가입된 멤버가 없습니다.")
//        );
//        return new SessionMember(member.getName(), member.getAge());
//    }

    public MemberCheckResponse check(String name) {
        if(name.isBlank() || name.isEmpty() || name.length() < 2) {
            throw new IllegalStateException("이름을 확인해주세요.");
        }
        boolean existence = memberRepository.existsByName(name);

        if(existence) {
            throw new MemberExistsException("이미 회원가입된 이름입니다.");
        }
        return new MemberCheckResponse("사용 가능한 이름입니다.");
    }
}
