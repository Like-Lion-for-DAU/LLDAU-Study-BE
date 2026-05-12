package week5.package2;


import week5.role.Lion;
import week5.role.Role;
import week5.role.Staff;

import java.util.Arrays;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    // 미리 정의된 더미 데이터
    private List<Role> mockData = Arrays.asList(
        new Lion("홍길동1", "컴퓨터공학과", 14, "백엔드", "202011111"),
        new Lion("홍길동2", "소프트웨어학과", 14, "프론트엔드", "202022222"),
        new Staff("홍길동3", "정보통신학과", 12, "디자인", "202033333")
    );

    @Override
    public void save(Role member) {
        // Mock: 실제 저장하지 않음
        System.out.println("[Mock] 저장 요청 - 실제 저장 안 함: " + member.getName());
    }

    @Override
    public Role findByName(String name) {
        for (Role member : mockData) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return mockData;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
