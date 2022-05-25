package com.example.demo.user.repository;

import com.example.demo.user.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    Member joinMember(Member member);

    Optional<Member> findbyId(Long id);

    List<Member> findAll();

    Optional<Member> findbyUserId(String userId);
}
