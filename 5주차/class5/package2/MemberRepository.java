package class5.package2;

import class5.role.Role;

import java.util.List;

public interface MemberRepository {

    void save(Role role);

    List<Role> findAll();

    Role findByName(String name);

    boolean existsByName(String name);
}