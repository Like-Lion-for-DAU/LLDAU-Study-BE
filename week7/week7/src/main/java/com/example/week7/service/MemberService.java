package com.example.week7.service;

import com.example.week7.dto.*;
import com.example.week7.repository.MemberRepository;
import com.example.week7.role.Lion;
import com.example.week7.role.Role;
import com.example.week7.role.Staff;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Lion createLion(LionCreateRequest request) {

        if (repository.existsByName(request.getName())) {
            return null;
        }

        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        repository.save(lion);

        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {

        if (repository.existsByName(request.getName())) {
            return null;
        }

        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        repository.save(staff);

        return staff;
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }

    public Lion updateLion(String name, LionUpdateRequest request) {

        Role role = repository.findByName(name);

        if (!(role instanceof Lion lion)) {
            return null;
        }

        lion.update(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {

        Role role = repository.findByName(name);

        if (!(role instanceof Staff staff)) {
            return null;
        }

        staff.update(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        return staff;
    }

    public boolean deleteMember(String name) {
        return repository.deleteByName(name);
    }
}