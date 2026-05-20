//Step1 : 수동 주입
package com.example.pbl.service;

import com.example.pbl.repository.MemberRepository;
import com.example.pbl.role.Role;

import java.util.List;

public class MemberService {

    private final MemberRepository repository;

    // 생성자 주입
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Role role) {

        if (repository.existsByName(role.getName())) {
            return false;
        }

        repository.save(role);
        return true;
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    public Role searchMember(String name) {
        return repository.findByName(name);
    }
}

//Step2 : 자동 주입

/*package com.example.pbl.service;

import com.example.pbl.repository.MemberRepository;
import com.example.pbl.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Role role) {

        if (repository.existsByName(role.getName())) {
            return false;
        }

        repository.save(role);
        return true;
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    public Role searchMember(String name) {
        return repository.findByName(name);
    }
}
*/