package com.example.demo;


import com.example.demo.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface MemberRepository {
    void save(Role role);
    Role findByName(String name);
    ArrayList<Role> findAll();
}
