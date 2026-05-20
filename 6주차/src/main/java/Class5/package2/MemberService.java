package Class5.package2;

import Class5.role.Role;
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

    public List<Role> findAllMembers() {
        return memberRepository.findAll();
    }

    public Role findMemberByName(String name) {
        return memberRepository.findByName(name);
    }
}
