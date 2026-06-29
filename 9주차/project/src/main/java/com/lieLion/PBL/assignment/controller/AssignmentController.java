package com.lieLion.PBL.assignment.controller;

import com.lieLion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lieLion.PBL.assignment.dto.AssignmentResponse;
import com.lieLion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lieLion.PBL.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // POST /members/{memberId}/assignments - 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(@PathVariable Long memberId,
                                                      @RequestBody AssignmentCreateRequest request) {
        AssignmentResponse response = assignmentService.create(memberId, request);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /members/{memberId}/assignments - 멤버별 과제 목록 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(assignmentService.findByMemberId(memberId));
    }

    // GET /assignments/{id} - 과제 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(@PathVariable Long id) {
        AssignmentResponse response = assignmentService.findById(id);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    // PUT /assignments/{id} - 과제 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(@PathVariable Long id,
                                                      @RequestBody AssignmentUpdateRequest request) {
        AssignmentResponse response = assignmentService.update(id, request);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    // DELETE /assignments/{id} - 과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
