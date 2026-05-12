package pk2;

import role.Lion;
import role.Role;

import java.util.ArrayList;

public class MockMemberRepository implements MemberRepository{
    @Override
    public void save(Role role) {
        System.out.println("[Mock]" + role.name + " 저장");
    }

    @Override
    public Role findByName(String name) {
        System.out.println("[Mock]"+name+"찾기");
        return new Lion(1,"없음","무",1,"없음",1);
    }

    @Override
    public ArrayList<Role> findAll() {
        ArrayList<Role> dummyList = new ArrayList<>();
        dummyList.add(new Lion(1,"없음","무",1,"없음",1));
        return dummyList;
    }

}
