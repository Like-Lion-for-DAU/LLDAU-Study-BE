package class5.package1;

import java.util.*;
import class5.role.wlq;

public class MemberRepository {

    private List<wlq> members = new ArrayList<>();

    public void save(wlq member) {
        members.add(member);
    }

    public wlq findByName(String name) {
        for (wlq member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<wlq> findAll() {
        return members;
    }

    public boolean existsByName(String name) {
        for (wlq member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}