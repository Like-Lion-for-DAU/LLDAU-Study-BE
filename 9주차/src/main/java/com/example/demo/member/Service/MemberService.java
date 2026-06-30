package com.example.demo.member.Service;

import com.example.demo.member.Repository.MemberRepository;
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
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public ArrayList<Member> getAllMembers() {
        return new ArrayList<>(memberRepository.findAll());
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Transactional
    public Member createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
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
            return null;
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
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isEmpty()) {
            return null;
        }

        Member member = optionalMember.get();
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
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isEmpty()) {
            return null;
        }

        Member member = optionalMember.get();
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
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return false;
        }

        memberRepository.delete(member);
        return true;
    }
}
