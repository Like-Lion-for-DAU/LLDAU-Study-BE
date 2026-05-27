package com.springbootbackend.lionspringboot.repository;


import com.springbootbackend.lionspringboot.domain.role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);

    void updateByName(String name, Role member);   // 이름으로 기존 멤버 교체
    boolean deleteByName(String name);              // 이름으로 멤버 삭제, 성공 여부 반환
}
