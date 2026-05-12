package class5.package2;

import class5.Member;
import class5.role.Lion;
import class5.policy.LionAssignmentPolicy;
import java.util.*;

public class MockMemberRepository implements MemberRepository {
    @Override
    public List<Member> findAll() {
        return List.of(new Member("가짜사자", "컴퓨터공학과", 14, "백엔드", "1234567", new Lion(), new LionAssignmentPolicy()));
    }
    @Override public void save(Member member) {}
    @Override public Member findByName(String name) { return null; }
    @Override public boolean existsByName(String name) { return false; }
}