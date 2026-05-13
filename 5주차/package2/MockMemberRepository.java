package package2;

import role.Lion;
import role.Role;

import java.util.ArrayList;

public class MockMemberRepository implements MemberRepository {
    private ArrayList<Role> members = new ArrayList<>();

    public MockMemberRepository() {
        members.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "202020202"));
        members.add(new Lion("이사자", "AI학과", 13, "프론트엔드", "202020203"));
    }

    @Override
    public boolean existsByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return true;
            }
        }   
        return false;
    }

    @Override
    public void save(Role role) {
        System.out.println("Mock 저장소입니다. 실제 저장되지 않습니다.");
    }

    @Override
    public ArrayList<Role> findAll() {
        return members;
    }

    @Override
    public Role findByName(String name) {
        for (Role role : members) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }
}