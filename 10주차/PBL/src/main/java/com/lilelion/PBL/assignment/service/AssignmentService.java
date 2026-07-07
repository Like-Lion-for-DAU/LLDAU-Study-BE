package com.lilelion.PBL.assignment.service;

import com.lilelion.PBL.assignment.domain.Assignment;
import com.lilelion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lilelion.PBL.assignment.dto.AssignmentResponse;
import com.lilelion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lilelion.PBL.assignment.repository.AssignmentRepository;
import com.lilelion.PBL.global.exception.AssignmentNotFoundException;
import com.lilelion.PBL.global.exception.MemberNotFoundException;
import com.lilelion.PBL.member.domain.Member;
import com.lilelion.PBL.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public AssignmentResponse createAssignment(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + memberId));

        Assignment assignment = Assignment.create(request.getTitle(), request.getDescription(), member);
        return new AssignmentResponse(assignmentRepository.save(assignment));
    }

    public AssignmentResponse getAssignment(Long id) {
        return new AssignmentResponse(findAssignmentOrElseThrow(id));
    }

    public List<AssignmentResponse> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }

    public List<AssignmentResponse> getAssignmentsByMember(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + memberId);
        }
        return assignmentRepository.findByMemberId(memberId).stream()
                .map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }

    public List<AssignmentResponse> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword).stream()
                .map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public AssignmentResponse updateAssignment(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = findAssignmentOrElseThrow(id);
        assignment.update(request.getTitle(), request.getDescription());
        return new AssignmentResponse(assignment);
    }

    @Transactional
    public void deleteAssignment(Long id) {
        Assignment assignment = findAssignmentOrElseThrow(id);
        assignmentRepository.delete(assignment);
    }

    private Assignment findAssignmentOrElseThrow(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("해당 과제를 찾을 수 없습니다. id: " + id));
    }
}
