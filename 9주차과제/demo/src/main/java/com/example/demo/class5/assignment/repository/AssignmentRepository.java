package com.example.demo.class5.assignment.repository;

import com.example.demo.class5.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByMemberId(Long memberId);
}