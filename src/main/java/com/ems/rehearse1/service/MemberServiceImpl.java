package com.ems.rehearse1.service;

import com.ems.rehearse1.domain.Member;
import com.ems.rehearse1.repository.JpaMemberRepository;
import com.ems.rehearse1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 3-2. Third
 *  - stable storing and modifying in JPA
 *  - auto register servcie
 */
@Transactional
@Service
public class MemberServiceImpl implements MemberService {

    /**
     * Case 1. Using memory repository
     */
//    private final MemberRepository memberRepository;
//    @Autowired
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * Case 2. Using JPA repository
     */
    private final JpaMemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(JpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member signup(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(mem -> { throw new IllegalStateException("Already existed name!"); });
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> findMemberById(long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findMemberByName(String name) {
        return memberRepository.findByName(name);
    }

}
