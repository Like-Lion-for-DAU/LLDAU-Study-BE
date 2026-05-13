package package1;

import role.Role;

import java.util.ArrayList;

public class MemberRepository {
    private ArrayList<Role> members = new ArrayList<>();

    public void save(Role role) {
        members.add(role);
    }

    public ArrayList<Role> findAll() {
        return members;
    }

    public boolean existsByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Role findByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }
}