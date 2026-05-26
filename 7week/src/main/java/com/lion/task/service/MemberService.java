package com.lion.task.service;

import com.lion.task.dto.*;
import com.lion.task.repository.*;
import com.lion.task.role.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Lion createLion(LionCreateRequest request) {
        if(memberRepository.existsByName(request.getName())) {
            return null;
        }

        Lion lion = new Lion(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {
        if(memberRepository.existsByName(request.getName())) {
            return null;
        }

        Staff staff = new Staff(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.save(staff);
        return staff;
    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        if(!memberRepository.existsByName(name)) {
            return null;
        }

        Lion lion = new Lion(name, request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.updateByName(name, lion);
        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {
        if(!memberRepository.existsByName(name)) {
            return null;
        }

        Staff staff = new Staff(name, request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.updateByName(name, staff);
        return staff;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }

    public Role findByName(String name)
    {
        return memberRepository.findByName(name);
    }

    public List<Role> findAll()
    {
        return memberRepository.findAll();
    }
}
