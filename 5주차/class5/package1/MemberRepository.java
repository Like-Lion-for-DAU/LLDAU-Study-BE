package class5.package1;

import class5.Member;
import java.util.*;

public class MemberRepository {
    private final Map<String, Member> store = new HashMap<>();

    public void save(Member member) { store.put(member.getName(), member); }
    public Member findByName(String name) { return store.get(name); }
    public List<Member> findAll() { return new ArrayList<>(store.values()); }
    public boolean existsByName(String name) { return store.containsKey(name); }
}