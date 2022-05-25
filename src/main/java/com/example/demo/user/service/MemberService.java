package com.example.demo.user.service;

import com.example.demo.user.domain.Member;
import com.example.demo.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member joinUser(Member member) {
        String passwordEncoding = passwordEncoding(member.getUserPw());
        member.setUserPw(passwordEncoding);
        log.info(passwordEncoding);
        memberRepository.joinMember(member);
        return member;
    }

    public String passwordEncoding(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public Member login(String userId, String userPw) {
        Optional<Member> findbyUserId = memberRepository.findbyUserId(userId);
        log.info(String.valueOf(findbyUserId));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return findbyUserId.orElse(null);

    }
}
