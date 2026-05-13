package class5.package2;

import java.util.ArrayList;
import java.util.List;

import class5.role.Lion;
import class5.role.Staff;
import class5.role.wlq;

public class MockMemberRepository implements MemberRepository {

    private List<wlq> mockMembers = new ArrayList<>();

    public MockMemberRepository() {

        mockMembers.add(new Lion("김나영", "컴공", 14, "백엔드", "2653745"));
        mockMembers.add(new Staff("운영진", "컴공", 14, "운영진", "백엔드"));
    }

    @Override
    public void save(wlq member) {
        System.out.println("Mock 저장소: 저장되지 않습니다.");
    }

    @Override
    public wlq findByName(String name) {

        for (wlq member : mockMembers) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public List<wlq> findAll() {
        return mockMembers;
    }

    @Override
    public boolean existsByName(String name) {

        for (wlq member : mockMembers) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}