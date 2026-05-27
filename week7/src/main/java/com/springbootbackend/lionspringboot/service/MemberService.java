
package com.springbootbackend.lionspringboot.service;


import com.springbootbackend.lionspringboot.domain.role.Lion;
import com.springbootbackend.lionspringboot.domain.role.Role;
import com.springbootbackend.lionspringboot.domain.role.Staff;
import com.springbootbackend.lionspringboot.dto.LionCreateRequest;
import com.springbootbackend.lionspringboot.dto.LionUpdateRequest;
import com.springbootbackend.lionspringboot.dto.StaffCreateRequest;
import com.springbootbackend.lionspringboot.dto.StaffUpdateRequest;
import com.springbootbackend.lionspringboot.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    // 생성자가 1개이므로 @Autowired 생략 가능
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // ===================== 생성 =====================

    /** Lion 생성. 이름이 중복이면 null 반환. */
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

    /** Staff 생성. 이름이 중복이면 null 반환. */
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

    // ===================== 조회 =====================

    public Role findByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> findAllMembers() {
        return repository.findAll();
    }

    // ===================== 수정 =====================

    /** Lion 수정. 멤버가 없거나 Lion이 아니면 null 반환. */
    public Lion updateLion(String name, LionUpdateRequest request) {
        Role found = repository.findByName(name);
        if (!(found instanceof Lion lion)) {
            return null;   // 존재하지 않거나 Staff인 경우
        }
        lion.setMajor(request.getMajor());
        lion.setGeneration(request.getGeneration());
        lion.setPart(request.getPart());
        lion.setStudentId(request.getStudentId());

        repository.updateByName(name, lion);
        return lion;
    }

    /** Staff 수정. 멤버가 없거나 Staff가 아니면 null 반환. */
    public Staff updateStaff(String name, StaffUpdateRequest request) {
        Role found = repository.findByName(name);
        if (!(found instanceof Staff staff)) {
            return null;
        }
        staff.setMajor(request.getMajor());
        staff.setGeneration(request.getGeneration());
        staff.setPart(request.getPart());
        staff.setPosition(request.getPosition());

        repository.updateByName(name, staff);
        return staff;
    }

    // ===================== 삭제 =====================

    /** 멤버 삭제. 성공하면 true, 없으면 false. */
    public boolean deleteMember(String name) {
        return repository.deleteByName(name);
    }
}