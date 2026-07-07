package com.lilelion.PBL.member.repository;

import com.lilelion.PBL.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByPart(String part);

    Optional<Member> findByName(String name);

    boolean existsByName(String name);
}
