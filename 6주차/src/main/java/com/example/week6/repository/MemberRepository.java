package com.example.week6.repository;

import com.example.week6.role.Role;

import java.util.List;

public interface MemberRepository {

    void save(Role role);

    List<Role> findAll();

    Role findByName(String name);

    boolean existsByName(String name);
}