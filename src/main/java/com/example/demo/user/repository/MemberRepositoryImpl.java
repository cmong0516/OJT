package com.example.demo.user.repository;

import com.example.demo.user.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
    private final EntityManager em;

    public MemberRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member joinMember(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findbyId(Long id) {
        return findAll().stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Optional<Member> findbyUserId(String userId) {
        return findAll().stream().filter(m -> m.getUserId().equals(userId)).findFirst();
    }
}
