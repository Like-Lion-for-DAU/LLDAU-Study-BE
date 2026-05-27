package com.example.demo.class5.service;

import org.springframework.stereotype.Service;

import com.example.demo.class5.role.Lion;
import com.example.demo.class5.role.wlq;
import com.example.demo.class5.role.Staff;
import com.example.demo.class5.dto.*;
import com.example.demo.class5.repository.MemberRepository;

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

    public wlq findByName(String name) {
        return repository.findByName(name);
    }

    public Lion updateLion(String name, LionUpdateRequest request) {

        wlq found = repository.findByName(name);

        if (found == null) {
            return null;
        }

        Lion lion = new Lion(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        repository.updateByName(name, lion);

        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {

        wlq found = repository.findByName(name);

        if (found == null) {
            return null;
        }

        Staff staff = new Staff(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        repository.updateByName(name, staff);

        return staff;
    }

    public boolean deleteMember(String name) {
        return repository.deleteByName(name);
    }
}