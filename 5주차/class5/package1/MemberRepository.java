package class5.package1;

import class5.role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private List<Role> members = new ArrayList<>();

    public void save(Role role) {
        members.add(role);
    }

    public List<Role> findAll() {
        return members;
    }

    public Role findByName(String name) {

        for (Role role : members) {

            if (role.getName().equals(name)) {
                return role;
            }
        }

        return null;
    }

    public boolean existsByName(String name) {

        for (Role role : members) {

            if (role.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}