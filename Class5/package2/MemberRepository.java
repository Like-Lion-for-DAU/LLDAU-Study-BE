package package2;

import role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role member);

    List<Role> findAll();

    Role findByName(String name);

    boolean existsByName(String name);
}
