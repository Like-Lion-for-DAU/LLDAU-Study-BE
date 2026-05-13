package repository;

import role.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberInMemoryRepository implements MemberRepository {
    Map<String, Role> members = new HashMap<>();
    public void save(Role role) {
        members.put(role.getName(), role);
    }
    public Role findByName(String name) {
        return members.get(name);
    }
    public List<Role> findAll() {
        return new ArrayList<>(members.values());
    }
    public Boolean existsByName(String name) {
        return members.containsKey(name);
    }
}
