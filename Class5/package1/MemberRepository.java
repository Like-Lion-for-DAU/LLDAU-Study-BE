package package1;

import role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private final List<Role> members = new ArrayList<>();

    public void save(Role member) {
        members.add(member);
    }

    public List<Role> findAll() {
        return members;
    }

    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
