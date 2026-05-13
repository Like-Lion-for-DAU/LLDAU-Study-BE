package package1;

import java.util.ArrayList;
import java.util.List;

import role.Role;

public class MemberRepository {

    private List<Role> members = new ArrayList<>();

    public void save(Role member) {
        members.add(member);
    }

    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    public List<Role> findAll() {
        return members;
    }

    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}