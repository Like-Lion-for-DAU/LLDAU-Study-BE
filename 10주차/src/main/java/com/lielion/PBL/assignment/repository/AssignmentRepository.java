package com.lielion.PBL.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lielion.PBL.assignment.domain.Assignment;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
	List<Assignment> findByMemberId(Long memberId);
	List<Assignment> findByTitleContaining(String keyword);
}
