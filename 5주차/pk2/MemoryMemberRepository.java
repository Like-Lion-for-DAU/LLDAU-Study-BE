package pk2;

import role.Role;

import java.util.ArrayList;

public class MemoryMemberRepository implements MemberRepository{
    private final ArrayList<Role> list = new ArrayList<>();

    @Override
    public void save(Role role) {
        list.add(role);
    }

    @Override
    public Role findByName(String name) {
        return list.stream().filter(r -> r.name.equals(name)).findFirst().orElse(null);
    }

    @Override
    public ArrayList<Role> findAll() {
        return new ArrayList<>(list);
    }
}
