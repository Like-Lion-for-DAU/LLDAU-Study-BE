package pk1;


import role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private final MemberRepository repository = new MemberRepository();

    public boolean check(Role role) {
        ArrayList<Role> list = repository.findAll();
        for(Role r : list){
            if (r.name.equals(role.name)) {
                return false;
            }
        }
        repository.save(role);
        return true;
    }

    // 전체 멤버 조회
    public List<Role> findMembers() {
        return repository.findAll();
    }

    // 이름으로 검색
    public Role findOne(String name) {
        return repository.findByName(name);
    }
}

