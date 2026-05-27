package com.example.week7.controller;

import com.example.week7.dto.*;
import com.example.week7.role.Lion;
import com.example.week7.role.Role;
import com.example.week7.role.Staff;
import com.example.week7.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/lions")
    public ResponseEntity<?> createLion(@RequestBody LionCreateRequest request) {

        Lion lion = service.createLion(request);

        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<?> createStaff(@RequestBody StaffCreateRequest request) {

        Staff staff = service.createStaff(request);

        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findMember(@PathVariable String name) {

        Role role = service.findByName(name);

        if (role == null) {
            return ResponseEntity.notFound().build();
        }

        if (role instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion));
        }

        Staff staff = (Staff) role;
        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<?> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request
    ) {

        Lion lion = service.updateLion(name, request);

        if (lion == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(LionResponse.from(lion));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<?> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request
    ) {

        Staff staff = service.updateStaff(name, request);

        if (staff == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {

        boolean deleted = service.deleteMember(name);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}