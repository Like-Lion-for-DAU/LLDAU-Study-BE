package com.lieLion.PBL.assignment.service;

import com.lieLion.PBL.assignment.domain.Assignment;
import com.lieLion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lieLion.PBL.assignment.dto.AssignmentResponse;
import com.lieLion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lieLion.PBL.assignment.repository.AssignmentRepository;
import com.lieLion.PBL.member.domain.Member;
import com.lieLion.PBL.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository,
                             MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    // 과제 등록
    @Transactional
    public AssignmentResponse create(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return null;
        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
        return AssignmentResponse.from(assignmentRepository.save(assignment));
    }

    // 멤버별 과제 목록 조회
    public List<AssignmentResponse> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId).stream()
                .map(AssignmentResponse::from)
                .collect(Collectors.toList());
    }

    // 과제 단건 조회
    public AssignmentResponse findById(Long id) {
        return assignmentRepository.findById(id)
                .map(AssignmentResponse::from)
                .orElse(null);
    }

    // 과제 수정
    @Transactional
    public AssignmentResponse update(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) return null;
        assignment.updateInfo(request.getTitle(), request.getDescription());
        return AssignmentResponse.from(assignmentRepository.save(assignment));
    }

    // 과제 삭제
    @Transactional
    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }
}
