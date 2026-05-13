package package2;

import java.util.ArrayList;
import java.util.List;
import role.Lion;
import role.Role;
import role.Staff;

public class MockMemberRepository implements MemberRepository {
    private List<Role> mockMembers = new ArrayList<Role>();

    public MockMemberRepository() {
        mockMembers.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "2022020202"));
        mockMembers.add(new Staff("홍사자", "소융과", 13, "프론트엔드", "대표"));
    }

    @Override
    public void save(Role member) {
        System.out.println("Mock 저장소는 실제 저장을 하지 않습니다.");
    }

    @Override
    public Role findByName(String name) {
        for (Role member : mockMembers) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return mockMembers;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}