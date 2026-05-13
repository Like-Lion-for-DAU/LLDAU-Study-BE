package class5.package2;

import class5.role.Role;
import java.util.List;

public class MemberService {

    private final MemberRepository repository;

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