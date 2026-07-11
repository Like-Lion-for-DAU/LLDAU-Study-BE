package com.lielion.PBL.member.repository;

import com.lielion.PBL.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);

    boolean existsByName(String name);
}
