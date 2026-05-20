package com.likelion.pbl.service;

import com.likelion.pbl.repository.MemberRepository;
import com.likelion.pbl.role.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean register(Role member) {
        if (memberRepository.existsByName(member.getName())) {
            return false;
        }

        memberRepository.save(member);
        return true;
    }

    public Role searchByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return memberRepository.findAll();
    }
}
