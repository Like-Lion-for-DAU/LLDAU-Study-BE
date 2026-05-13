package package2;

import role.Role;

import java.util.ArrayList;

public interface MemberRepository {
    void save(Role role);

    boolean existsByName(String name);

    ArrayList<Role> findAll();

    Role findByName(String name);
}