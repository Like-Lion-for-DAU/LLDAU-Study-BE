package com.springbootbackend.lionspringboot.repository;


import com.springbootbackend.lionspringboot.domain.role.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//<Member, Long>은 "Member 엔티티를 다루고, 그 기본키 타입은 Long"이라는 뜻
public interface MemberRepository extends JpaRepository<Member, Long> {
    // save(), findById(), findAll(), deleteById(), existsById() 자동 제공
    Member findByName(String name);  // findBy + 필드명 규칙으로 자동 쿼리 생성
}