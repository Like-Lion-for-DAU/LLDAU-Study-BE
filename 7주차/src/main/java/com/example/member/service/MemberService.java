package com.example.member.service;

import com.example.member.domain.role.Lion;
import com.example.member.domain.role.Role;
import com.example.member.domain.role.Staff;
import com.example.member.dto.LionCreateRequest;
import com.example.member.dto.LionUpdateRequest;
import com.example.member.dto.StaffCreateRequest;
import com.example.member.dto.StaffUpdateRequest;
import com.example.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Lion createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }

        Lion lion = request.toEntity();
        memberRepository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }

        Staff staff = request.toEntity();
        memberRepository.save(staff);
        return staff;
    }

    public List<Role> findAllMembers() {
        return memberRepository.findAll();
    }

    public Role findMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        Role member = memberRepository.findByName(name);
        if (!(member instanceof Lion)) {
            return null;
        }

        Lion lion = request.toEntity(name);
        memberRepository.updateByName(name, lion);
        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {
        Role member = memberRepository.findByName(name);
        if (!(member instanceof Staff)) {
            return null;
        }

        Staff staff = request.toEntity(name);
        memberRepository.updateByName(name, staff);
        return staff;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}
