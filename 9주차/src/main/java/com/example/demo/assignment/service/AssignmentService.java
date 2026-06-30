package com.example.demo.assignment.service;

import com.example.demo.member.Repository.MemberRepository;
import com.example.demo.assignment.domain.Assignment;
import com.example.demo.assignment.repository.AssignmentRepository;
import com.example.demo.member.domain.Member;
import com.example.demo.assignment.dto.AssignmentCreateRequest;
import com.example.demo.assignment.dto.AssignmentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Assignment createAssignment(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }

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

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Assignment updateAssignment(Long id, AssignmentUpdateRequest request) {
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
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return false;
        }

        assignmentRepository.delete(assignment);
        return true;
    }
}
