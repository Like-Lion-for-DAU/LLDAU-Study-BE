package com.springbootbackend.lionspringboot.assignment.service;


import com.springbootbackend.lionspringboot.assignment.domain.Assignment;
import com.springbootbackend.lionspringboot.assignment.dto.AssignmentCreateRequest;
import com.springbootbackend.lionspringboot.assignment.dto.AssignmentUpdateRequest;
import com.springbootbackend.lionspringboot.assignment.repository.AssignmentRepository;
import com.springbootbackend.lionspringboot.global.exception.AssignmentNotFoundException;
import com.springbootbackend.lionspringboot.global.exception.MemberNotFoundException;
import com.springbootbackend.lionspringboot.member.domain.Member;
import com.springbootbackend.lionspringboot.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//은행에서 A 계좌에서 돈을 빼고 B 계좌에 넣는데, 빼기까지만 성공하고 넣다가 서버가 죽으면? 돈이 증발.
// 전부 성공하거나, 아니면 전부 없던 일로 되돌리거나 — 이게 트랜잭션. 중간에 실패하면 통째로 롤백.
//readOnly = true, "이 트랜잭션에서는 데이터를 읽기만 하고 변경하지 않는다."
@Service
@Transactional(readOnly = true)     // 클래스 레벨 기본값: 읽기 전용
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository,
                             MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    // ===== 과제 등록 =====
    //반면 데이터를 변경하는 메서드(create, update, delete)에는 메서드 위에 @Transactional을 따로 붙임.
    @Transactional      // 데이터 변경 → 읽기 전용 해제
    public Assignment create(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(
                        "id=" + memberId + "인 멤버를 찾을 수 없습니다."));
        Assignment assignment = new Assignment(
                request.getTitle(),
                request.getDescription(),
                member
        );
        return assignmentRepository.save(assignment);
    }

    // ===== 멤버별 과제 조회 ===== (클래스 레벨 readOnly = true 적용)
    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    // ===== 단건 조회 =====
    public Assignment findById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException(
                        "id=" + id + "인 과제를 찾을 수 없습니다."));
    }

    // ===== 전체 조회 ===== (클래스 레벨 readOnly = true 적용)
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    // ===== 제목 검색 =====
    public List<Assignment> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContainingIgnoreCase(keyword);
    }


    // ===== 수정 =====
    @Transactional
    public Assignment update(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException(
                        "id=" + id + "인 과제를 찾을 수 없습니다."));

        assignment.updateInfo(request.getTitle(), request.getDescription());
        return assignmentRepository.save(assignment);
    }

    // ===== 삭제 =====
    @Transactional
    public void delete(Long id) {
        if (!assignmentRepository.existsById(id)) {
            throw new AssignmentNotFoundException(
                    "id=" + id + "인 과제를 찾을 수 없습니다.");
        }
        assignmentRepository.deleteById(id);
    }
}
