package pk1;

import role.Role;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private final ArrayList<Role> list = new ArrayList<>();

    public void save(Role role) {
        list.add(role);
    }

    public Role findByName(String name) {
        for (Role r : list) {
            if (r.name.equals(name)) return r;
        }
        return null;
    }

    public ArrayList<Role> findAll() {
        return new ArrayList<>(list);
    }
}