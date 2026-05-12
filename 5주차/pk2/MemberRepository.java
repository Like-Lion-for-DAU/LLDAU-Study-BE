package pk2;

import role.Role;

import java.util.ArrayList;

public interface MemberRepository {
    void save(Role role);
    Role findByName(String name);
    ArrayList<Role> findAll();
}
