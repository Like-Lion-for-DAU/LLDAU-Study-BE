package com.springbootbackend.lionspringboot.assignment.repository;


import com.springbootbackend.lionspringboot.assignment.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    // 메서드 이름 규칙으로 자동 쿼리 생성: WHERE member_id = ?
    List<Assignment> findByMemberId(Long memberId);
}
