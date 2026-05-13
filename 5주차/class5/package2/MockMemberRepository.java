package class5.package2;

import class5.role.Lion;
import class5.role.Role;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {

    @Override
    public void save(Role role) {

        System.out.println("[Mock] 실제 저장은 수행하지 않습니다.");
    }

    @Override
    public List<Role> findAll() {

        List<Role> mockList = new ArrayList<>();

        mockList.add(new Lion(
                "김사자",
                "컴퓨터공학과",
                14,
                "백엔드",
                "202020202"
        ));

        mockList.add(new Lion(
                "이사자",
                "AI학과",
                13,
                "프론트엔드",
                "202020203"
        ));

        return mockList;
    }

    @Override
    public Role findByName(String name) {

        if (name.equals("김사자")) {

            return new Lion(
                    "김사자",
                    "컴퓨터공학과",
                    14,
                    "백엔드",
                    "202020202"
            );
        }

        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}