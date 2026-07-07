package com.lilelion.PBL.assignment.controller;

import com.lilelion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lilelion.PBL.assignment.dto.AssignmentResponse;
import com.lilelion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lilelion.PBL.assignment.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    // POST /members/{memberId}/assignments
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request) {
        AssignmentResponse response = assignmentService.createAssignment(memberId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /assignments (전체 조회)
    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentResponse>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    // GET /members/{memberId}/assignments (멤버별 조회)
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> getAssignmentsByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByMember(memberId));
    }

    // GET /assignments/search?keyword= (제목 검색) - {id}보다 먼저 매핑되어야 함
    @GetMapping("/assignments/search")
    public ResponseEntity<List<AssignmentResponse>> searchAssignments(@RequestParam String keyword) {
        return ResponseEntity.ok(assignmentService.searchByTitle(keyword));
    }

    // GET /assignments/{id} (단건 조회)
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> getAssignment(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentService.getAssignment(id));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request) {
        return ResponseEntity.ok(assignmentService.updateAssignment(id, request));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
