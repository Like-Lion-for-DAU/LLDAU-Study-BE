package com.springbootbackend.lionspringboot.service;


import com.springbootbackend.lionspringboot.repository.MemberRepository;
import com.springbootbackend.lionspringboot.role.Lion;
import com.springbootbackend.lionspringboot.role.Role;
import com.springbootbackend.lionspringboot.role.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    // 인터페이스에만 의존 (느슨한 결합)
    // 생성자가 1개이므로 @Autowired 생략 가능
    private final MemberRepository repository;

    // 생성자 ← 스프링이 여기 보고 MemberRepository 타입의 Bean이 필요하구나 판단
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }


    public Role registerMember(int roleChoice, String name, String major,
                               int generation, String part, String studentId) {
        if (repository.existsByName(name)) {
            throw new IllegalStateException("이미 존재하는 이름입니다: " + name);
        }

        Role member;
        if (roleChoice == 1) {
            member = new Lion(name, major, generation, part, studentId);
        } else {
            member = new Staff(name, major, generation, part, studentId);
        }

        repository.save(member);
        return member;
    }

    public List<Role> findAllMembers() {
        return repository.findAll();
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }
}

