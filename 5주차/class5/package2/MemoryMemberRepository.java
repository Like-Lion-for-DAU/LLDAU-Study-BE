package class5.package2;

import class5.Member;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private final Map<String, Member> store = new HashMap<>();
    @Override public void save(Member member) { store.put(member.getName(), member); }
    @Override public Member findByName(String name) { return store.get(name); }
    @Override public List<Member> findAll() { return new ArrayList<>(store.values()); }
    @Override public boolean existsByName(String name) { return store.containsKey(name); }
}