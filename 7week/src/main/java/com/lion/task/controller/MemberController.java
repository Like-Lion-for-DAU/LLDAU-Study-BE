package com.lion.task.controller;

import com.lion.task.dto.*;
import com.lion.task.role.*;
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
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        Lion lion = memberService.createLion(request);
        if(lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);
        if(staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findMember(@PathVariable String name) {
        Role member = memberService.findByName(name);
        if(member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toResponse(member));
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request) {
        Lion lion = memberService.updateLion(name, request);
        if(lion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LionResponse.from(lion));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request) {
        Staff staff = memberService.updateStaff(name, request);
        if(staff == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        if(!memberService.deleteMember(name)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // 전체 조회. name 주면 그걸로 검색.
    @GetMapping
    public ResponseEntity<List<Object>> findMembers(@RequestParam(required = false) String name) {
        List<Object> result = new ArrayList<>();
        for (Role member : memberService.findAll()) {
            if(name != null && !member.getName().equals(name)) {
                continue;
            }
            result.add(toResponse(member));
        }
        return ResponseEntity.ok(result);
    }

    private Object toResponse(Role member) {
        if(member instanceof Lion) {
            return LionResponse.from((Lion) member);
        }
        return StaffResponse.from((Staff) member);
    }
}
