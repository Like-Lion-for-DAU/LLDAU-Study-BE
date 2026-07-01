package com.lielion.PBL.assignment.service;

import com.lielion.PBL.assignment.domain.Assignment;
import com.lielion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lielion.PBL.assignment.dto.AssignmentResponse;
import com.lielion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lielion.PBL.assignment.repository.AssignmentRepository;
import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AssignmentService {
	private final AssignmentRepository assignmentRepository;
	private final MemberRepository memberRepository;

	public AssignmentService(AssignmentRepository assignmentRepository, MemberRepository memberRepository) {
		this.assignmentRepository = assignmentRepository;
		this.memberRepository = memberRepository;
	}

	@Transactional
	public AssignmentResponse createAssignment(Long memberId, AssignmentCreateRequest request) {
		Member member = memberRepository.findById(memberId).orElse(null);
		if (member == null) {
			return null;
		}
		Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
		Assignment saved = assignmentRepository.save(assignment);
		return AssignmentResponse.from(saved);
	}

	public List<AssignmentResponse> getAssignmentsByMemberId(Long memberId) {
		return assignmentRepository.findByMemberId(memberId)
			.stream()
			.map(AssignmentResponse::from)
			.collect(Collectors.toList());
	}

	public AssignmentResponse getById(Long id) {
		return assignmentRepository.findById(id)
			.map(AssignmentResponse::from)
			.orElse(null);
	}

	@Transactional
	public AssignmentResponse updateAssignment(Long id, AssignmentUpdateRequest request) {
		Assignment assignment = assignmentRepository.findById(id).orElse(null);
		if (assignment == null) {
			return null;
		}
		assignment.updateInfo(request.getTitle(), request.getDescription());
		assignmentRepository.save(assignment);
		return AssignmentResponse.from(assignment);
	}

	@Transactional
	public void deleteById(Long id) {
		assignmentRepository.deleteById(id);
	}
}
