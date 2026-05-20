package Class5.package2;

import Class5.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final List<Role> members = new ArrayList<>();

    @Override
    public void save(Role member) {
        members.add(member);
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
