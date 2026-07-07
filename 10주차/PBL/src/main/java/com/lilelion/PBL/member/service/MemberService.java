package com.lilelion.PBL.member.service;

import com.lilelion.PBL.global.exception.DuplicateMemberException;
import com.lilelion.PBL.global.exception.MemberNotFoundException;
import com.lilelion.PBL.member.domain.Member;
import com.lilelion.PBL.member.dto.*;
import com.lilelion.PBL.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse createLion(LionCreateRequest request) {
        validateDuplicateName(request.getName());
        Member member = Member.createLion(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), request.getStudentId());
        return new MemberResponse(memberRepository.save(member));
    }

    @Transactional
    public MemberResponse createStaff(StaffCreateRequest request) {
        validateDuplicateName(request.getName());
        Member member = Member.createStaff(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), request.getPosition());
        return new MemberResponse(memberRepository.save(member));
    }

    private void validateDuplicateName(String name) {
        if (memberRepository.existsByName(name)) {
            throw new DuplicateMemberException("이미 존재하는 이름입니다. name: " + name);
        }
    }

    public MemberResponse getMember(Long id) {
        Member member = findMemberOrElseThrow(id);
        return new MemberResponse(member);
    }

    public List<MemberResponse> getMembers(String part) {
        List<Member> members = (part == null || part.isBlank())
                ? memberRepository.findAll()
                : memberRepository.findByPart(part);

        return members.stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public MemberResponse updateLion(Long id, LionUpdateRequest request) {
        Member member = findMemberOrElseThrow(id);
        member.updateLion(request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getStudentId());
        return new MemberResponse(member);
    }

    @Transactional
    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
        Member member = findMemberOrElseThrow(id);
        member.updateStaff(request.getName(), request.getMajor(),
                request.getGeneration(), request.getPart(), request.getPosition());
        return new MemberResponse(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        Member member = findMemberOrElseThrow(id);
        memberRepository.delete(member);
    }

    private Member findMemberOrElseThrow(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + id));
    }
}
