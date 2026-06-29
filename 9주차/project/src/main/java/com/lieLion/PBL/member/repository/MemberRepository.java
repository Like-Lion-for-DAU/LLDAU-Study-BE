package com.lieLion.PBL.member.repository;

import com.lieLion.PBL.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
