package com.example.demo.member.Repository;

import com.example.demo.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);

    List<Member> findByPart(String part);
}
