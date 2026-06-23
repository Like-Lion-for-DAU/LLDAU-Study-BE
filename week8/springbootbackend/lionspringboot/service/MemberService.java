package com.springbootbackend.lionspringboot.service;


import com.springbootbackend.lionspringboot.domain.role.Member;
import com.springbootbackend.lionspringboot.domain.role.RoleType;
import com.springbootbackend.lionspringboot.dto.*;
import com.springbootbackend.lionspringboot.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // 생성
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
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = repository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return repository.save(member);
    }

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
    public boolean deleteMember(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}