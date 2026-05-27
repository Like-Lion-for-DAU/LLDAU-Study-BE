package com.likelion.pbl.controller;

import com.likelion.pbl.domain.role.Lion;
import com.likelion.pbl.domain.role.Role;
import com.likelion.pbl.domain.role.Staff;
import com.likelion.pbl.dto.LionCreateRequest;
import com.likelion.pbl.dto.LionResponse;
import com.likelion.pbl.dto.LionUpdateRequest;
import com.likelion.pbl.dto.StaffCreateRequest;
import com.likelion.pbl.dto.StaffResponse;
import com.likelion.pbl.dto.StaffUpdateRequest;
import com.likelion.pbl.service.MemberService;
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
        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getMember(@PathVariable String name) {
        Role member = memberService.searchByName(name);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(toResponse(member));
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request
    ) {
        Lion lion = memberService.updateLion(name, request);
        if (lion == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(LionResponse.from(lion));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request
    ) {
        Staff staff = memberService.updateStaff(name, request);
        if (staff == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        if (!memberService.deleteMember(name)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    private Object toResponse(Role member) {
        if (member instanceof Lion lion) {
            return LionResponse.from(lion);
        }

        return StaffResponse.from((Staff) member);
    }
}
