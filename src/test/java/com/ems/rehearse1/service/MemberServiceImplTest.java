package com.ems.rehearse1.service;

import com.ems.rehearse1.domain.Member;
import com.ems.rehearse1.repository.JpaMemberRepository;
import com.ems.rehearse1.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemberServiceImplTest {

    MemoryMemberRepository memberRepository;
    MemberServiceImpl memberService;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void signup1() {
        // 1. given
        Member member = new Member();
        member.setId(1L);
        member.setName("john");
        member.setAge(38);
        // 2. when
        Member signupMember = memberService.signup(member);
        // 3. then
        Assertions.assertThat(signupMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(signupMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(signupMember.getAge()).isEqualTo(member.getAge());
    }

    @Test
    void signup2() {
        // 1. given
        Member member = new Member();
        member.setId(1L);
        member.setName("john");
        member.setAge(38);
        // 2. when
        Member signupMember = memberService.signup(member);
        // 3. then
        IllegalStateException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.signup(member));
        Assertions.assertThat(e.getMessage()).isEqualTo("Already existed name!");
    }

    @Test
    void findMemberById() {
        // 1. given
        Member member = new Member();
        member.setId(1L);
        member.setName("john");
        member.setAge(38);
        // 2. when
        Member signupMember = memberService.signup(member);
        Member foundMember = memberService.findMemberById(member.getId()).get();
        // 3. then
        Assertions.assertThat(foundMember).isEqualTo(foundMember);
    }

    @Test
    void findAllMembers() {
        // 1. given
        Member member1 = new Member();
        member1.setId(1L);
        member1.setName("john");
        member1.setAge(38);
        memberService.signup(member1);
        Member member2 = new Member();
        member2.setId(2L);
        member2.setName("jane");
        member2.setAge(30);
        memberService.signup(member2);
        // 2. when
        List<Member> foundMembers = memberService.findAllMembers();
        // 3. then
        Assertions.assertThat(foundMembers.size()).isEqualTo(2);
    }
}