package com.springbootbackend.lionspringboot.controller;

import com.springbootbackend.lionspringboot.domain.role.Member;
import com.springbootbackend.lionspringboot.dto.*;
import com.springbootbackend.lionspringboot.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // POST /members/lions
    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
        Member member = memberService.createLion(request);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member));
    }

    // POST /members/staffs
    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Member member = memberService.createStaff(request);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member));
    }

    // GET /members  (전체 조회)
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> responses = memberService.findAllMembers()
                .stream().map(MemberResponse::from).toList();
        return ResponseEntity.ok(responses);
    }

    // GET /members/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    // PUT /members/lions/{id}
    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(
            @PathVariable Long id, @RequestBody LionUpdateRequest request) {
        Member member = memberService.updateLion(id, request);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    // PUT /members/staffs/{id}
    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(
            @PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        Member member = memberService.updateStaff(id, request);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    // DELETE /members/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.deleteMember(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}