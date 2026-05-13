package repository;

import role.Lion;
import role.Role;

import java.util.List;

public class MemberMockRepository implements MemberRepository {
    Role mockedMember = new Lion(
            "나지성",
            "컴퓨터공학과",
            14,
            "백엔드",
            "21"
    );

    @Override
    public void save(Role member) {
    }

    @Override
    public Role findByName(String name) {
        return name.equals("나지성") ? mockedMember : null;
    }

    @Override
    public List<Role> findAll() {
        return List.of(mockedMember);
    }

    @Override
    public Boolean existsByName(String name) {
        return name.equals("나지성");
    }
}
