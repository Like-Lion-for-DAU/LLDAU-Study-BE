package package1;

import java.util.List;

import role.Role;

public class MemberService {

    // Step1 핵심: 직접 생성
    private MemberRepository repository = new MemberRepository();

    public boolean register(Role member) {

        if (repository.existsByName(member.getName())) {
            return false;
        }

        repository.save(member);
        return true;
    }

    public Role searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }
}