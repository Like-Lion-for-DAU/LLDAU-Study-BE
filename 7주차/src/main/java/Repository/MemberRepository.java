package Repository;

import Role.Role;

import java.util.ArrayList;


public interface MemberRepository {
    ArrayList<Role> findAll();
    void save(Role member);
    Role findByName(String name);
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
}
