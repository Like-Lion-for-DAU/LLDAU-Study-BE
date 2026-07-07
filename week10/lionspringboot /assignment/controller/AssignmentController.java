package com.springbootbackend.lionspringboot.assignment.controller;


import com.springbootbackend.lionspringboot.assignment.domain.Assignment;
import com.springbootbackend.lionspringboot.assignment.dto.AssignmentCreateRequest;
import com.springbootbackend.lionspringboot.assignment.dto.AssignmentResponse;
import com.springbootbackend.lionspringboot.assignment.dto.AssignmentUpdateRequest;
import com.springbootbackend.lionspringboot.assignment.service.AssignmentService;
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


    // GET /assignments → 전체 과제 조회
    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentResponse>> findAll() {
        List<AssignmentResponse> result = assignmentService.findAll()
                .stream()
                .map(AssignmentResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    // GET /assignments/search?keyword=... → 제목 검색
    @GetMapping("/assignments/search")
    public ResponseEntity<List<AssignmentResponse>> search(@RequestParam String keyword) {
        List<AssignmentResponse> result = assignmentService.searchByTitle(keyword)
                .stream()
                .map(AssignmentResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    // POST /members/{memberId}/assignments → 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request) {
        Assignment assignment = assignmentService.create(memberId, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AssignmentResponse.from(assignment));   // 201
    }

    // GET /members/{memberId}/assignments → 멤버별 과제 목록 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findByMember(@PathVariable Long memberId) {
        List<AssignmentResponse> result = assignmentService.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    // GET /assignments/{id} → 과제 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findOne(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    // PUT /assignments/{id} → 과제 수정
    // 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request) {
        Assignment assignment = assignmentService.update(id, request);
        return ResponseEntity.ok(AssignmentResponse.from(assignment));   // 200
    }

    // DELETE /assignments/{id} → 과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assignmentService.delete(id);

        return ResponseEntity.noContent().build();      // 204
    }
}
