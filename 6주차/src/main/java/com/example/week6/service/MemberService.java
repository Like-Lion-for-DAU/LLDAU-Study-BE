package com.example.week6.service;

import com.example.week6.repository.MemberRepository;
import com.example.week6.role.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void register(Role role) {

        if (repository.existsByName(role.getName())) {
            System.out.println("이미 존재하는 이름입니다.");
            return;
        }

        repository.save(role);
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }
}