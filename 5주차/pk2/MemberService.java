package pk2;

import role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean check(Role role) {
        ArrayList<Role> list = repository.findAll();
        for(Role r : list){
            if (r.name.equals(role.name)) {
                return false;
            }
        }
        repository.save(role);
        return true;
    }

    public List<Role> findMembers() {
        return repository.findAll();
    }

    public Role findOne(String name) {
        return repository.findByName(name);
    }
}
