package com.example.demo.class5.assignment.service;

import com.example.demo.class5.assignment.repository.AssignmentRepository;
import com.example.demo.class5.domain.Assignment;
import com.example.demo.class5.domain.Member;
import com.example.demo.class5.repository.MemberRepository;
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
    public Assignment create(Long memberId, String title, String description) {
        Member member = memberRepository.findById(memberId).orElse(null);

        if (member == null) {
            return null;
        }

        Assignment assignment = new Assignment(title, description, member);
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Assignment update(Long id, String title, String description) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);

        if (assignment == null) {
            return null;
        }

        assignment.updateInfo(title, description);
        return assignmentRepository.save(assignment);
    }

    @Transactional
    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }
}