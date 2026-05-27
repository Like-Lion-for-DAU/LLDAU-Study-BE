package com.example.member.repository;

import com.example.member.domain.role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role member);

    List<Role> findAll();

    Role findByName(String name);

    void updateByName(String name, Role member);

    boolean deleteByName(String name);

    boolean existsByName(String name);
}
