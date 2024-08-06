package com.ems.rehearse1.service;

import com.ems.rehearse1.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * 3-1. Third
 */
public interface MemberService {

    Member signup(Member member);
    Optional<Member> findMemberById(long memberId);
    List<Member> findAllMembers();
    Optional<Member> findMemberByName(String memberName);
}
