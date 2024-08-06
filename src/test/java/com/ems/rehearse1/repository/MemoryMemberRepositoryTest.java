package com.ems.rehearse1.repository;

import com.ems.rehearse1.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * 2-3. Second
 */
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        // 1. given
        Member member = new Member();
        member.setName("john");
        member.setAge(38);
        // 2. when
        repository.save(member);
        Member foundMember = repository.findById(member.getId()).get();
        // 3. then
        Assertions.assertThat(foundMember).isEqualTo(member);
    }

    @Test
    void findById() {
        // 1. given
        Member member1 = new Member();
        member1.setName("john");
        member1.setAge(38);
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("jane");
        member2.setAge(30);
        repository.save(member2);
        // 2. when
        Member foundMember1 = repository.findById(member1.getId()).get();
        Member foundMember2 = repository.findById(member2.getId()).get();
        // 3. then
        Assertions.assertThat(foundMember1).isEqualTo(member1);
        Assertions.assertThat(foundMember2).isEqualTo(member2);
        Assertions.assertThat(foundMember1).isNotEqualTo(member2);
        Assertions.assertThat(foundMember2).isNotEqualTo(member1);
    }

    @Test
    void findByName() {
        // 1. given
        Member member1 = new Member();
        member1.setName("john");
        member1.setAge(38);
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("jane");
        member2.setAge(30);
        repository.save(member2);
        // 2. when
        Member foundMember1 = repository.findByName("john").get();
        Member foundMember2 = repository.findByName("jane").get();
        // 3. then
        Assertions.assertThat(foundMember1).isEqualTo(member1);
        Assertions.assertThat(foundMember2).isEqualTo(member2);
        Assertions.assertThat(foundMember1).isNotEqualTo(member2);
        Assertions.assertThat(foundMember2).isNotEqualTo(member1);
    }

    @Test
    void findAll() {
        // 1. given
        Member member1 = new Member();
        member1.setName("john");
        member1.setAge(38);
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("jane");
        member2.setAge(30);
        repository.save(member2);
        // 2. when
        List<Member> foundMembers = repository.findAll();
        // 3. then
        Assertions.assertThat(foundMembers.size()).isEqualTo(2);
        Assertions.assertThat(foundMembers.size()).isNotEqualTo(1);
        Assertions.assertThat(foundMembers.size()).isNotEqualTo(3);
    }

}
