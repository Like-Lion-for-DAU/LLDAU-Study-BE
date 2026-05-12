package class5.package1;

import class5.Member;
import java.util.List;

public class MemberService {
    // 제약사항: 내부에서 직접 생성하여 사용
    private final MemberRepository repository = new MemberRepository();

    public String register(Member member) {
        if (repository.existsByName(member.getName())) return "실패: 중복된 이름";
        repository.save(member);
        return "성공: " + member.getName();
    }

    public List<Member> findAll() { return repository.findAll(); }
    public Member findOne(String name) { return repository.findByName(name); }
}