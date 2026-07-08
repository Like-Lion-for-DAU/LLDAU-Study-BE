package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Lion;
import com.example.demo.domain.Member;
import com.example.demo.domain.Staff;
import com.example.demo.dto.LionRequestDto;
import com.example.demo.dto.StaffRequestDto;
import com.example.demo.repository.MemberRepository;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/lions")
    public ResponseEntity<Lion> createLion(@RequestBody LionRequestDto dto) {
        Lion lion = new Lion(null, dto.getName(), dto.getStudentId());
        Member saved = memberRepository.save(lion);
        return ResponseEntity.status(HttpStatus.CREATED).body((Lion) saved);
    }

    @PostMapping("/staffs")
    public ResponseEntity<Staff> createStaff(@RequestBody StaffRequestDto dto) {
        Staff staff = new Staff(null, dto.getName(), dto.getPosition());
        Member saved = memberRepository.save(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body((Staff) saved);
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<Lion> updateLion(@PathVariable Long id, @RequestBody LionRequestDto dto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다. id=" + id));
        
        if (!(member instanceof Lion)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Lion lion = (Lion) member;
        lion.setStudentId(dto.getStudentId());
        memberRepository.save(lion);
        return ResponseEntity.ok(lion);
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody StaffRequestDto dto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다. id=" + id));

        if (!(member instanceof Staff)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Staff staff = (Staff) member;
        staff.setPosition(dto.getPosition());
        memberRepository.save(staff);
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다. id=" + id));
        return ResponseEntity.ok(member);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다. id=" + id));
        memberRepository.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}