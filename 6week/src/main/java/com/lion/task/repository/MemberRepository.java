package com.lion.task.repository;

import com.lion.task.role.*;

import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    Boolean existsByName(String name);
}
