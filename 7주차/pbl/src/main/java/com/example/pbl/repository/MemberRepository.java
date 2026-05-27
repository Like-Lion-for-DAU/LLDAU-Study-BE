package com.example.pbl.repository;

import com.example.pbl.domain.role.Role;
import java.util.List;

public interface MemberRepository {

    void save(Role role);

    List<Role> findAll();

    Role findByName(String name);

    boolean existsByName(String name);

    void updateByName(String name, Role role);

    boolean deleteByName(String name);
}
