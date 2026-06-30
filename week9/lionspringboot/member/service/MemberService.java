package com.springbootbackend.lionspringboot.member.service;


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
            return null;  // 이름 중복
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
            return null;
        }
        Member member = new Member(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.STAFF, null, request.getPosition()
        );
        return repository.save(member);
    }

    // ===== 조회 =====

    public Member findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }

    // ===== 수정 =====
    @Transactional      // ← 추가
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return repository.save(member);
    }

    @Transactional      // ← 추가
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return repository.save(member);
    }

    // ===== 삭제 =====
    @Transactional      // ← 추가
    public boolean deleteMember(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}