package service;

import repository.*;
import role.*;

import java.util.List;

public class MemberService {
    private static final MemberInMemoryRepository memberRepository = new MemberInMemoryRepository();

    public void register(Role member) {
        if(memberRepository.nameExists(member.getName())) {
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
