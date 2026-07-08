package com.example.demo.service;

import com.example.demo.entity.Assignment;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AssignmentService {

    private final MemberRepository memberRepository;

    public AssignmentService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registerAssignment(Long memberId, String assignmentTitle) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다. ID: " + memberId));

        Assignment assignment = new Assignment();
        assignment.setTitle(assignmentTitle);

        member.addAssignment(assignment);
        // 영속성 전이(Cascade) 덕분에 자동으로 데이터가 저장
    }
}