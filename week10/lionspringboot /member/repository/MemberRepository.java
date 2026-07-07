package com.springbootbackend.lionspringboot.member.repository;


import com.springbootbackend.lionspringboot.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//<Member, Long>은 "Member 엔티티를 다루고, 그 기본키 타입은 Long"이라는 뜻
public interface MemberRepository extends JpaRepository<Member, Long> {
    // save(), findById(), findAll(), deleteById(), existsById() 자동 제공
    Member findByName(String name);  // findBy + 필드명 규칙으로 자동 쿼리 생성
    // 신규: 파트로 필터링 (예: "백엔드"인 멤버만)
    List<Member> findByPart(String part);
}