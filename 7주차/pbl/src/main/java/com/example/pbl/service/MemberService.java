package com.example.pbl.service;

import com.example.pbl.domain.role.Lion;
import com.example.pbl.domain.role.Role;
import com.example.pbl.domain.role.Staff;
import com.example.pbl.dto.*;
import com.example.pbl.repository.MemberRepository;
import org.springframework.stereotype.Service;

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

        Lion lion = new Lion(
                request.name(),
                request.major(),
                request.generation(),
                request.part(),
                request.studentId()
        );

        memberRepository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.name())) {
            return null;
        }

        Staff staff = new Staff(
                request.name(),
                request.major(),
                request.generation(),
                request.part(),
                request.position()
        );

        memberRepository.save(staff);
        return staff;
    }

    public Role findByName(String name) {
        return memberRepository.findByName(name);
    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        if (!memberRepository.existsByName(name)) {
            return null;
        }

        Lion lion = new Lion(
                name,
                request.major(),
                request.generation(),
                request.part(),
                request.studentId()
        );

        memberRepository.updateByName(name, lion);
        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {
        if (!memberRepository.existsByName(name)) {
            return null;
        }

        Staff staff = new Staff(
                name,
                request.major(),
                request.generation(),
                request.part(),
                request.position()
        );

        memberRepository.updateByName(name, staff);
        return staff;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}