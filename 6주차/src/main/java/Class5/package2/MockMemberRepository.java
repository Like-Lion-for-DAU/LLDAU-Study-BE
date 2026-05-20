package Class5.package2;

import Class5.role.Lion;
import Class5.role.Role;
import Class5.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private final List<Role> members = new ArrayList<>();

    public MockMemberRepository() {
        members.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "202020202"));
        members.add(new Staff("박운영", "경영학과", 13, "기획", "회장"));
    }

    @Override
    public void save(Role member) {
        System.out.println("MockMemberRepository는 실제 저장을 하지 않습니다.");
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
