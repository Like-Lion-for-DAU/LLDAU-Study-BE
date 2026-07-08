package com.example.week10.member.controller;

import com.example.week10.member.domain.Member;
import com.example.week10.member.dto.*;
import com.example.week10.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(
            @RequestBody LionCreateRequest request) {

        Member member = service.createLion(request);

        return ResponseEntity.status(201)
                .body(MemberResponse.from(member));
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(
            @RequestBody StaffCreateRequest request) {

        Member member = service.createStaff(request);

        return ResponseEntity.status(201)
                .body(MemberResponse.from(member));
    }

    @GetMapping
    public List<MemberResponse> getMembers(
            @RequestParam(required = false) String part){

        List<Member> members;

        if(part == null){

            members = service.findAll();

        }else{

            members = service.findByPart(part);

        }

        return members.stream()
                .map(MemberResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> findById(
            @PathVariable Long id) {

        Member member = service.findById(id);

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(
            @PathVariable Long id,
            @RequestBody LionUpdateRequest request) {

        Member member = service.updateLion(id, request);

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(
            @PathVariable Long id,
            @RequestBody StaffUpdateRequest request) {

        Member member = service.updateStaff(id, request);

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable Long id) {

        service.deleteMember(id);

        return ResponseEntity.noContent().build();
    }
}