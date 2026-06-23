package com.likelion.pbl.service;

import com.likelion.pbl.domain.Member;
import com.likelion.pbl.domain.RoleType;
import com.likelion.pbl.dto.LionCreateRequest;
import com.likelion.pbl.dto.LionUpdateRequest;
import com.likelion.pbl.dto.StaffCreateRequest;
import com.likelion.pbl.dto.StaffUpdateRequest;
import com.likelion.pbl.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member createLion(LionCreateRequest request) {
        if (memberRepository.findByName(request.getName()).isPresent()) {
            return null;
        }

        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.LION,
                request.getStudentId(),
                null
        );
        return memberRepository.save(member);
    }

    public Member createStaff(StaffCreateRequest request) {
        if (memberRepository.findByName(request.getName()).isPresent()) {
            return null;
        }

        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.STAFF,
                null,
                request.getPosition()
        );
        return memberRepository.save(member);
    }

    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return memberRepository.save(member);
    }

    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }

        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return memberRepository.save(member);
    }

    public boolean deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            return false;
        }

        memberRepository.deleteById(id);
        return true;
    }
}
