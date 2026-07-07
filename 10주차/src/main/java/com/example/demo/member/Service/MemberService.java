package com.example.demo.member.Service;

import com.example.demo.member.Repository.MemberRepository;
import com.example.demo.global.exception.DuplicateMemberNameException;
import com.example.demo.global.exception.MemberNotFoundException;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.RoleType;
import com.example.demo.member.dto.LionCreateRequest;
import com.example.demo.member.dto.LionUpdateRequest;
import com.example.demo.member.dto.StaffCreateRequest;
import com.example.demo.member.dto.StaffUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public ArrayList<Member> getAllMembers() {
        return new ArrayList<>(memberRepository.findAll());
    }

    public List<Member> getMembersByPart(String part) {
        return memberRepository.findByPart(part);
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
    }

    @Transactional
    public Member createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            throw new DuplicateMemberNameException("이미 존재하는 멤버 이름입니다.");
        }

        Member lion = new Member(
                request.getName(),
                request.getMajor(),
                request.getPart(),
                request.getGeneration(),
                RoleType.LION,
                request.getStudentId(),
                null
        );

        return memberRepository.save(lion);
    }
    @Transactional
    public Member createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            throw new DuplicateMemberNameException("이미 존재하는 멤버 이름입니다.");
        }

        Member staff = new Member(
                request.getName(),
                request.getMajor(),
                request.getPart(),
                request.getGeneration(),
                RoleType.STAFF,
                null,
                request.getPosition()
        );

        return memberRepository.save(staff);
    }
    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
        if (member.getRoleType() != RoleType.LION) {
            return null;
        }

        member.updateInfo(
                member.getName(),
                request.getMajor(),
                request.getPart(),
                request.getGeneration(),
                RoleType.LION
        );
        member.updateStudentId(String.valueOf(request.getStudentId()));
        member.updatePosition(null);

        return memberRepository.save(member);
    }
    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
        if (member.getRoleType() != RoleType.STAFF) {
            return null;
        }

        member.updateInfo(
                member.getName(),
                request.getMajor(),
                request.getPart(),
                request.getGeneration(),
                RoleType.STAFF
        );
        member.updateStudentId(null);
        member.updatePosition(request.getPosition());

        return memberRepository.save(member);
    }
    @Transactional
    public boolean deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        memberRepository.delete(member);
        return true;
    }
}
