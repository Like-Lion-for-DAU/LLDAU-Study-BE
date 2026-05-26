package com.lion.task.repository;

import com.lion.task.role.*;

import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    Boolean existsByName(String name);
}
