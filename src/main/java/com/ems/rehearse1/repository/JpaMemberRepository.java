package com.ems.rehearse1.repository;

import com.ems.rehearse1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);
}
