package repository;

import role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    Boolean existsByName(String name);
}
