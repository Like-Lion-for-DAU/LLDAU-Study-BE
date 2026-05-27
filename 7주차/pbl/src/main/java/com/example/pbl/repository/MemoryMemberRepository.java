package com.example.pbl.repository;

import com.example.pbl.domain.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<Role> members = new ArrayList<>();

    @Override
    public void save(Role role) {
        members.add(role);
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public Role findByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return role;
            }
        }

        return null;
    }

    @Override
    public boolean existsByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void updateByName(String name, Role role) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(name)) {
                members.set(i, role);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return members.removeIf(role -> role.getName().equals(name));
    }
}
