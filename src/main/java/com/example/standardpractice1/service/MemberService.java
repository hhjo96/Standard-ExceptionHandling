package com.example.standardpractice1.service;

import com.example.standardpractice1.dto.*;
import com.example.standardpractice1.entity.Member;
import com.example.standardpractice1.exception.MemberCountOver10Exception;
import com.example.standardpractice1.exception.MemberExistsException;
import com.example.standardpractice1.exception.MemberNotFoundException;
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
            throw new MemberCountOver10Exception("가입된 회원이 10명을 초과합니다.");
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
