package com.ems.rehearse1.repository;

import com.ems.rehearse1.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * 2-1. Second
 */
public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(long id);

    List<Member> findAll();

    Optional<Member> findByName(String name);

}
