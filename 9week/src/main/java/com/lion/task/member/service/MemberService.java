package com.lion.task.member.service;

import com.lion.task.member.domain.*;
import com.lion.task.member.dto.*;
import com.lion.task.member.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member createLion(LionCreateRequest request) {
        if(memberRepository.existsByName(request.getName())) {
            return null;
        }

        Member member = new Member(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), RoleType.LION, request.getStudentId(), null);
        return memberRepository.save(member);
    }

    @Transactional
    public Member createStaff(StaffCreateRequest request) {
        if(memberRepository.existsByName(request.getName())) {
            return null;
        }

        Member member = new Member(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), RoleType.STAFF, null, request.getPosition());
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if(member == null) {
            return null;
        }

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if(member == null) {
            return null;
        }

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return memberRepository.save(member);
    }

    @Transactional
    public boolean deleteMember(Long id) {
        if(!memberRepository.existsById(id)) {
            return false;
        }

        memberRepository.deleteById(id);
        return true;
    }

    public Member findById(Long id)
    {
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> findAll()
    {
        return memberRepository.findAll();
    }
}
