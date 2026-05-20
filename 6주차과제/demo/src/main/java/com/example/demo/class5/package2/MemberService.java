package com.example.demo.class5.package2;

import java.util.List;

import com.example.demo.class5.role.wlq;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(wlq member) {

        if (repository.existsByName(member.getName())) {
            return false;
        }

        repository.save(member);
        return true;
    }

    public wlq searchByName(String name) {
        return repository.findByName(name);
    }

    public List<wlq> getAllMembers() {
        return repository.findAll();
    }
}