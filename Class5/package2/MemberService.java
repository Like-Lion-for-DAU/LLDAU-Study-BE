package package2;

import role.Role;

import java.util.List;

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

    public List<Role> findAllMembers() {
        return memberRepository.findAll();
    }

    public Role findMemberByName(String name) {
        return memberRepository.findByName(name);
    }
}
