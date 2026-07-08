package com.lielion.PBL.member.repository;

import com.lielion.PBL.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);

    List<Member> findByPart(String part);

    boolean existsByName(String name);
}
