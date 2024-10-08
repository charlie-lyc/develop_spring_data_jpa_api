package com.ems.rehearse1.repository;

import com.ems.rehearse1.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 2-2. Second
 *  - auto register repository bean
 */
@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++ sequence);
        store.put(member.getId(), member);
        return store.get(member.getId());
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    public void clearStore() {
        store.clear();
    }

}
