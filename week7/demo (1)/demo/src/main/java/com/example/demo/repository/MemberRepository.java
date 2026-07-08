package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemberRepository {
    private final Map<Long, Member> store = new HashMap<>();
    private long sequence = 0L;

    public Member save(Member member) {
        if (member.getId() == null) {
            member.setId(++sequence);
        }
        store.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void delete(Long id) {
        store.remove(id);
    }
}