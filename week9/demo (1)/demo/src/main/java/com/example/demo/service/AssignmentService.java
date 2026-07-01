package com.example.demo.service;

import com.example.demo.entity.Assignment;
import com.example.demo.entity.Member;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) // 읽기 작업 안정성 확보
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    // 과제 등록 (데이터를 저장하므로 쓰기 트랜잭션 적용 -> 실패 시 자동 롤백)
    @Transactional
    public Assignment createAssignment(Long memberId, String title) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다. ID: " + memberId));

        Assignment assignment = new Assignment(title, member);
        return assignmentRepository.save(assignment);
    }
}