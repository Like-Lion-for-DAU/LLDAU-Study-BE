package package2;

import role.Role;

import java.util.ArrayList;

public class MemoryMemberRepository implements MemberRepository {
    private ArrayList<Role> members = new ArrayList<>();

    @Override
    public boolean existsByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(Role role) {
        members.add(role);
    }

    @Override
    public ArrayList<Role> findAll() {
        return members;
    }

    @Override
    public Role findByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }
}