package class5.package2;

import java.util.ArrayList;
import java.util.List;

import class5.role.wlq;

public class MemoryMemberRepository implements MemberRepository {

    private List<wlq> members = new ArrayList<>();

    @Override
    public void save(wlq member) {
        members.add(member);
    }

    @Override
    public wlq findByName(String name) {

        for (wlq member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public List<wlq> findAll() {
        return members;
    }

    @Override
    public boolean existsByName(String name) {

        for (wlq member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}