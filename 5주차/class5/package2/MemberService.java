package class5.package2;

import class5.Member;
import java.util.List;

public class MemberService {
    // 제약사항: 인터페이스에만 의존하며 final로 설정
    private final MemberRepository repository;

    // 생성자를 통해 주입받음 (DI)
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member findByName(String name) { 
        return repository.findByName(name);
    }

    public String register(Member member) {
        if (repository.existsByName(member.getName())) return "실패(중복된 이름)";
        repository.save(member);
        return "등록 완료";
    }

    public List<Member> findAll() { return repository.findAll(); }
    public Member findOne(String name) { return repository.findByName(name); }
}