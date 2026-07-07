package com.lielion.PBL.assignment.service;

import com.lielion.PBL.assignment.domain.Assignment;
import com.lielion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lielion.PBL.assignment.dto.AssignmentResponse;
import com.lielion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lielion.PBL.assignment.repository.AssignmentRepository;
import com.lielion.PBL.global.exception.AssignmentNotFoundException;
import com.lielion.PBL.global.exception.MemberNotFoundException;
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
		Member member = memberRepository.findById(memberId)
			.orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + memberId));
		Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
		Assignment saved = assignmentRepository.save(assignment);
		return AssignmentResponse.from(saved);
	}

	public List<AssignmentResponse> findAll() {
		return assignmentRepository.findAll()
			.stream()
			.map(AssignmentResponse::from)
			.collect(Collectors.toList());
	}

	public List<AssignmentResponse> getAssignmentsByMemberId(Long memberId) {
		return assignmentRepository.findByMemberId(memberId)
			.stream()
			.map(AssignmentResponse::from)
			.collect(Collectors.toList());
	}

	public AssignmentResponse getById(Long id) {
		Assignment assignment = assignmentRepository.findById(id)
			.orElseThrow(() -> new AssignmentNotFoundException("해당 과제를 찾을 수 없습니다. id: " + id));
		return AssignmentResponse.from(assignment);
	}

	public List<AssignmentResponse> searchByTitle(String keyword) {
		return assignmentRepository.findByTitleContaining(keyword)
			.stream()
			.map(AssignmentResponse::from)
			.collect(Collectors.toList());
	}

	@Transactional
	public AssignmentResponse updateAssignment(Long id, AssignmentUpdateRequest request) {
		Assignment assignment = assignmentRepository.findById(id)
			.orElseThrow(() -> new AssignmentNotFoundException("해당 과제를 찾을 수 없습니다. id: " + id));
		assignment.updateInfo(request.getTitle(), request.getDescription());
		assignmentRepository.save(assignment);
		return AssignmentResponse.from(assignment);
	}

	@Transactional
	public void deleteById(Long id) {
		Assignment assignment = assignmentRepository.findById(id)
			.orElseThrow(() -> new AssignmentNotFoundException("해당 과제를 찾을 수 없습니다. id: " + id));
		assignmentRepository.deleteById(id);
	}
}
