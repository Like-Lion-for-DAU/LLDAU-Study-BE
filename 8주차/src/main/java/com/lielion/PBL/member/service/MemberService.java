package com.lielion.PBL.member.service;

import com.lielion.PBL.member.domain.Member;
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
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateLion(Long id, String major, int generation, String part, String studentId) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(major, generation, part);
        member.updateStudentId(studentId);
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateStaff(Long id, String major, int generation, String part, String position) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(major, generation, part);
        member.updatePosition(position);
        return memberRepository.save(member);
    }

    @Transactional
    public boolean deleteById(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
