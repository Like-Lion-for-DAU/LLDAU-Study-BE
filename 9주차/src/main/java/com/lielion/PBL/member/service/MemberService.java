package com.lielion.PBL.member.service;

import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.domain.RoleType;
import com.lielion.PBL.member.dto.LionCreateRequest;
import com.lielion.PBL.member.dto.LionUpdateRequest;
import com.lielion.PBL.member.dto.StaffCreateRequest;
import com.lielion.PBL.member.dto.StaffUpdateRequest;
import com.lielion.PBL.member.repository.MemberRepository;
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
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }

        Member member = request.toEntity();
        return memberRepository.save(member);
    }

    @Transactional
    public Member createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }

        Member member = request.toEntity();
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        member.updatePosition(null);
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(null);
        member.updatePosition(request.getPosition());
        return memberRepository.save(member);
    }

    @Transactional
    public boolean deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            return false;
        }

        memberRepository.deleteById(id);
        return true;
    }
}
