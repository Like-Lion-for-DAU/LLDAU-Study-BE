package com.example.demo;

import com.example.demo.MemberRepository;
import com.example.demo.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final ArrayList<Role> list = new ArrayList<>();

    @Override
    public void save(Role role) {
        list.add(role);
    }

    @Override
    public Role findByName(String name) {
        return list.stream().filter(r -> r.name.equals(name)).findFirst().orElse(null);
    }

    @Override
    public ArrayList<Role> findAll() {
        return new ArrayList<>(list);
    }
}
