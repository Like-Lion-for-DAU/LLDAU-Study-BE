package service;

import repository.*;
import role.*;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void register(Role member) {
        if(memberRepository.existsByName(member.getName())) {
            throw new IllegalStateException("같은 이름의 멤버가 존재.");
        }

        memberRepository.save(member);
    }

    public Role findByName(String name)
    {
        return memberRepository.findByName(name);
    }

    public List<Role> findAll()
    {
        return memberRepository.findAll();
    }
}
