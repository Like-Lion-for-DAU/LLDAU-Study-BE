package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<String, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getName(), member);
    }

    @Override
    public Member findByName(String name) {
        return store.get(name);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}