package com.springbootbackend.lionspringboot.member.service;


import com.springbootbackend.lionspringboot.global.exception.DuplicateMemberException;
import com.springbootbackend.lionspringboot.global.exception.MemberNotFoundException;
import com.springbootbackend.lionspringboot.member.dto.LionCreateRequest;
import com.springbootbackend.lionspringboot.member.dto.LionUpdateRequest;
import com.springbootbackend.lionspringboot.member.dto.StaffCreateRequest;
import com.springbootbackend.lionspringboot.member.dto.StaffUpdateRequest;
import com.springbootbackend.lionspringboot.member.domain.Member;
import com.springbootbackend.lionspringboot.member.domain.RoleType;
import com.springbootbackend.lionspringboot.member.dto.*;
import com.springbootbackend.lionspringboot.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)     // ← 클래스 레벨 추가
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // 생성
    @Transactional      // ← 추가
    public Member createLion(LionCreateRequest request) {
        if (repository.findByName(request.getName()) != null) {
            throw new DuplicateMemberException(
                    "이미 존재하는 이름입니다: " + request.getName());
        }
        Member member = new Member(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.LION, request.getStudentId(), null
        );
        return repository.save(member);  // save() 후 id가 채워진 Member 반환
    }

    @Transactional      // ← 추가
    public Member createStaff(StaffCreateRequest request) {
        if (repository.findByName(request.getName()) != null) {
            throw new DuplicateMemberException(
                    "이미 존재하는 이름입니다: " + request.getName());
        }
        Member member = new Member(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.STAFF, null, request.getPosition()
        );
        return repository.save(member);
    }

    // ===== 조회 =====

//    public Member findById(Long id) {
//        return repository.findById(id).orElse(null);
//    }

    // 변경 후 — orElse(null) → orElseThrow(...)
    public Member findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(
                        "id=" + id + "인 멤버를 찾을 수 없습니다."));
    }


    public List<Member> findAllMembers() {
        return repository.findAll();
    }

    // ===== 신규: 파트별 조회 =====
// part가 없으면(전체 파트 선택) 전체 반환, 있으면 해당 파트만 필터.
    public List<Member> findMembers(String part) {
        if (part == null || part.isBlank()) {
            return repository.findAll();
        }
        return repository.findByPart(part);
    }

    // ===== 수정 =====
    @Transactional      // ← 추가
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(
                        "id=" + id + "인 멤버를 찾을 수 없습니다."));

        if (member.getRoleType() != RoleType.LION) {
            // 멤버는 있지만 Lion이 아님 → 잘못된 요청(400)이 자연스러움
            throw new IllegalArgumentException(
                    "id=" + id + "는 아기사자(Lion)가 아닙니다.");
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return repository.save(member);
    }

    @Transactional      // ← 추가
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(
                        "id=" + id + "인 멤버를 찾을 수 없습니다."));

        if (member.getRoleType() != RoleType.STAFF) {
            // 멤버는 있지만 Lion이 아님 → 잘못된 요청(400)이 자연스러움
            throw new IllegalArgumentException(
                    "id=" + id + "는 스탭(staff)이 아닙니다.");
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return repository.save(member);
    }

    // ===== 삭제 =====
    @Transactional
    public void deleteMember(Long id) {
        if (!repository.existsById(id)) {
            throw new MemberNotFoundException(
                    "id=" + id + "인 멤버를 찾을 수 없습니다.");
        }
        repository.deleteById(id);
    }
}