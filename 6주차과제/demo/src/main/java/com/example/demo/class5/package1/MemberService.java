package com.example.demo.class5.package1;

import java.util.List;
import com.example.demo.class5.role.wlq;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void register(wlq member) {
        if (repository.existsByName(member.getName())) {
            System.out.println("등록실패 : 이미 존재하는 이름입니다.");
            return;
        }
        repository.save(member);
        System.out.println("등록 완료");
    }

    public wlq searchByName(String name) {
        return repository.findByName(name);
    }

    public List<wlq> getAllMembers() {
        return repository.findAll();
    }
}