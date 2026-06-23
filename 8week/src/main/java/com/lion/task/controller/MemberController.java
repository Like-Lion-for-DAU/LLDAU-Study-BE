package com.lion.task.controller;

import com.lion.task.domain.*;
import com.lion.task.dto.*;
import com.lion.task.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
        Member member = memberService.createLion(request);
        if(member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member));
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Member member = memberService.createStaff(request);
        if(member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> findMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if(member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest request) {
        Member member = memberService.updateLion(id, request);
        if(member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        Member member = memberService.updateStaff(id, request);
        if(member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        if(!memberService.deleteMember(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // 전체 조회. name 주면 그걸로 검색.
    @GetMapping
    public ResponseEntity<List<MemberResponse>> findMembers(@RequestParam(required = false) String name) {
        List<MemberResponse> result = new ArrayList<>();
        for (Member member : memberService.findAll()) {
            if(name != null && !member.getName().equals(name)) {
                continue;
            }
            result.add(MemberResponse.from(member));
        }
        return ResponseEntity.ok(result);
    }
}
