package class5.package1;

import class5.role.Role;

import java.util.List;

public class MemberService {

    // Step1 : 직접 생성 (강한 결합)
    private MemberRepository repository = new MemberRepository();

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