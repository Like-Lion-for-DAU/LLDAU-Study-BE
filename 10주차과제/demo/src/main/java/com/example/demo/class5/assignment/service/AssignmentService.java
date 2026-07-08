package com.example.demo.class5.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.class5.assignment.repository.AssignmentRepository;
import com.example.demo.class5.domain.Assignment;
import com.example.demo.class5.domain.Member;
import com.example.demo.class5.repository.MemberRepository;
import com.example.demo.class5.global.exception.AssignmentNotFoundException;
import com.example.demo.class5.global.exception.MemberNotFoundException;
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
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        Assignment assignment = new Assignment(title, description, member);
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    public List<Assignment> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("과제를 찾을 수 없습니다."));
    }

    @Transactional
    public Assignment update(Long id, String title, String description) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("과제를 찾을 수 없습니다."));

        assignment.updateInfo(title, description);
        return assignmentRepository.save(assignment);
    }

    @Transactional
    public void delete(Long id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("과제를 찾을 수 없습니다."));

        assignmentRepository.delete(assignment);
    }
}