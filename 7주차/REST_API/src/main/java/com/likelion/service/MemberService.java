package com.likelion.service;

import com.likelion.domain.role.Lion;
import com.likelion.domain.role.Role;
import com.likelion.domain.role.Staff;
import com.likelion.dto.*;
import org.springframework.stereotype.Service;
import com.likelion.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Lion createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.name())) {
            return null;
        }
        Lion lion = new Lion(request.name(), request.major(), request.generation(), request.part(), request.studentId());
        memberRepository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.name())) {
            return null;
        }
        Staff staff = new Staff(request.name(), request.major(), request.generation(), request.part(), request.position());
        memberRepository.save(staff);
        return staff;
    }

    public Role findMember(String name) {
        return memberRepository.findByName(name);
    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        Role member = memberRepository.findByName(name);
        if (member instanceof Lion lion) {
            lion.updateLionInfo(request.major(), request.generation(), request.part(), request.studentId());
            memberRepository.updateByName(name, lion);
            return lion;
        }
        return null;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {
        Role member = memberRepository.findByName(name);
        if (member instanceof Staff staff) {
            staff.updateStaffInfo(request.major(), request.generation(), request.part(), request.position());
            memberRepository.updateByName(name, staff);
            return staff;
        }
        return null;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}