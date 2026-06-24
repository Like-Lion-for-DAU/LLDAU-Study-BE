package com.lielion.PBL.member.controller;

import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.domain.RoleType;
import com.lielion.PBL.member.dto.*;
import com.lielion.PBL.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
        Member member = new Member(
            request.getName(),
            request.getMajor(),
            request.getPart(),
            request.getGeneration(),
            RoleType.LION,
            request.getStudentId(),
            null
        );
        Member savedMember = memberService.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(savedMember));
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Member member = new Member(
            request.getName(),
            request.getMajor(),
            request.getPart(),
            request.getGeneration(),
            RoleType.STAFF,
            null,
            request.getPosition()
        );
        Member savedMember = memberService.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(savedMember));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<Member> members = memberService.findAll();
        List<MemberResponse> responses = members.stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest request) {
        Member updatedMember = memberService.updateLion(
            id, request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId()
        );
        if (updatedMember == null) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.ok(MemberResponse.from(updatedMember));
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        Member updatedMember = memberService.updateStaff(
            id, request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition()
        );
        if (updatedMember == null) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.ok(MemberResponse.from(updatedMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.deleteById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
