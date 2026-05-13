package class5.package1;

import java.util.List;

import class5.role.wlq;

public class MemberService {

    private MemberRepository repository = new MemberRepository();

    public void register(wlq member) {

        if (repository.existsByName(member.getName())) {
            System.out.println("등록실패 : 이미 존재하는 이름입니다.");
            return;
        }

        repository.save(member);
        System.out.println("등록 완료");
    }

    public wlq searchByName(String name) {
        return repository.findByName(name);
    }

    public List<wlq> getAllMembers() {
        return repository.findAll();
    }
}