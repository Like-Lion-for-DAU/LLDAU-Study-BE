package com.lion.task.assignment.repository;

import com.lion.task.assignment.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByMemberId(Long memberId);

    @Query("SELECT a FROM Assignment a WHERE a.title LIKE %:keyword%")
    List<Assignment> searchByTitle(@Param("keyword") String keyword);
}
