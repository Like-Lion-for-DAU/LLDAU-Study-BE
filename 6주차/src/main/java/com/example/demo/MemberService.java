package com.example.demo;

import com.example.demo.MemberRepository;
import com.example.demo.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean check(Role role) {
        ArrayList<Role> list = repository.findAll();
        for(Role r : list){
            if (r.name.equals(role.name)) {
                return false;
            }
        }
        repository.save(role);
        return true;
    }

    public List<Role> findMembers() {
        return repository.findAll();
    }

    public Role findOne(String name) {
        return repository.findByName(name);
    }
}
