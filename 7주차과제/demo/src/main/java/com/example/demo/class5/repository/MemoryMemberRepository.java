package com.example.demo.class5.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.class5.role.wlq;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<wlq> members = new ArrayList<>();

    @Override
    public void save(wlq member) {
        members.add(member);
    }

    @Override
    public List<wlq> findAll() {
        return members;
    }

    @Override
    public wlq findByName(String name) {

        for (wlq member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public void updateByName(String name, wlq member) {

        for (int i = 0; i < members.size(); i++) {

            if (members.get(i).getName().equals(name)) {
                members.set(i, member);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return members.removeIf(member -> member.getName().equals(name));
    }

    @Override
    public boolean existsByName(String name) {

        for (wlq member : members) {

            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}