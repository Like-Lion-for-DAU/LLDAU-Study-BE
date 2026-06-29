package com.lieLion.PBL.member.service;

import com.lieLion.PBL.member.domain.Member;
import com.lieLion.PBL.member.domain.RoleType;
import com.lieLion.PBL.member.dto.*;
import com.lieLion.PBL.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse createLion(LionCreateRequest request) {
        Member member = new Member(request.getName(), request.getEmail(), RoleType.LION, request.getGeneration());
        return MemberResponse.from(memberRepository.save(member));
    }

    @Transactional
    public MemberResponse createStaff(StaffCreateRequest request) {
        Member member = new Member(request.getName(), request.getEmail(), RoleType.STAFF, request.getDepartment());
        return MemberResponse.from(memberRepository.save(member));
    }

    public List<MemberResponse> findAll() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }

    public MemberResponse findById(Long id) {
        return memberRepository.findById(id)
                .map(MemberResponse::from)
                .orElse(null);
    }

    @Transactional
    public MemberResponse updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) return null;
        member.updateLion(request.getName(), request.getEmail(), request.getGeneration());
        return MemberResponse.from(memberRepository.save(member));
    }

    @Transactional
    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) return null;
        member.updateStaff(request.getName(), request.getEmail(), request.getDepartment());
        return MemberResponse.from(memberRepository.save(member));
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
