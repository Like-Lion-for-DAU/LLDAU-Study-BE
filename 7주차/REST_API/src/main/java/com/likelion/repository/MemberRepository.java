package com.likelion.repository;

import com.likelion.domain.role.Role;

public interface MemberRepository {
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
    void save(Role member);
    Role findByName(String name);
}