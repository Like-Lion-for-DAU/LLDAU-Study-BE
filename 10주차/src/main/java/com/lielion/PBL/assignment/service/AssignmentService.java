package com.lielion.PBL.assignment.service;

import com.lielion.PBL.assignment.domain.Assignment;
import com.lielion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lielion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lielion.PBL.assignment.repository.AssignmentRepository;
import com.lielion.PBL.global.exception.AssignmentNotFoundException;
import com.lielion.PBL.global.exception.MemberNotFoundException;
import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(
            AssignmentRepository assignmentRepository,
            MemberRepository memberRepository
    ) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Assignment createAssignment(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));

        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findAllAssignments() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> findAssignmentsByMemberId(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new MemberNotFoundException(memberId);
        }

        return assignmentRepository.findByMemberId(memberId);
    }

    public List<Assignment> searchAssignments(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword);
    }

    public Assignment findAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException(id));
    }

    @Transactional
    public Assignment updateAssignment(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException(id));

        assignment.updateInfo(request.getTitle(), request.getDescription());
        return assignmentRepository.save(assignment);
    }

    @Transactional
    public void deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) {
            throw new AssignmentNotFoundException(id);
        }

        assignmentRepository.deleteById(id);
    }
}
