//package com.springbootbackend.lionspringboot.repository;
//
//
//import com.springbootbackend.lionspringboot.domain.role.Role;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class MemoryMemberRepository implements MemberRepository {
//    private final List<Role> members = new ArrayList<>();
//
//    @Override
//    public void save(Role member) {
//        members.add(member);
//    }
//
//    @Override
//    public Role findByName(String name) {
//        for (Role member : members) {
//            if (member.getName().equals(name)) {
//                return member;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Role> findAll() {
//        return members;
//    }
//
//    @Override
//    public boolean existsByName(String name) {
//        return findByName(name) != null;
//    }
//
//    @Override
//    public void updateByName(String name, Role member) {
//        // 리스트를 순회하며 이름이 일치하면 해당 인덱스를 교체
//        for (int i = 0; i < members.size(); i++) {
//            if (members.get(i).getName().equals(name)) {
//                members.set(i, member);
//                return;
//            }
//        }
//    }
//
//    @Override
//    public boolean deleteByName(String name) {
//        // removeIf: 이름이 일치하는 멤버를 제거, 제거되었으면 true
//        return members.removeIf(member -> member.getName().equals(name));
//    }
//}