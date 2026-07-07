package com.lielion.PBL.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lielion.PBL.member.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByPart(String part);
    Optional<Member> findByName(String name);
}
