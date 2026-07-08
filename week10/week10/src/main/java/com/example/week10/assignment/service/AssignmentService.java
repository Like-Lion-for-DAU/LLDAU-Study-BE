package com.example.week10.assignment.service;

import com.example.week10.assignment.domain.Assignment;
import com.example.week10.assignment.dto.AssignmentCreateRequest;
import com.example.week10.assignment.dto.AssignmentUpdateRequest;
import com.example.week10.assignment.repository.AssignmentRepository;
import com.example.week10.global.exception.AssignmentNotFoundException;
import com.example.week10.global.exception.MemberNotFoundException;
import com.example.week10.member.domain.Member;
import com.example.week10.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public Assignment createAssignment(Long memberId,
                                       AssignmentCreateRequest request) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        Assignment assignment = new Assignment(
                request.getTitle(),
                request.getDescription(),
                member
        );

        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    // 전체 과제 조회
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    // 제목 검색
    public List<Assignment> search(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new AssignmentNotFoundException("과제를 찾을 수 없습니다."));
    }

    @Transactional
    public Assignment updateAssignment(Long id,
                                       AssignmentUpdateRequest request) {

        Assignment assignment = assignmentRepository.findById(id).orElse(null);

        if (assignment == null) {
            return null;
        }

        assignment.updateInfo(
                request.getTitle(),
                request.getDescription()
        );

        return assignmentRepository.save(assignment);
    }

    @Transactional
    public boolean deleteAssignment(Long id) {

        if (!assignmentRepository.existsById(id)) {
            return false;
        }

        assignmentRepository.deleteById(id);

        return true;
    }

}