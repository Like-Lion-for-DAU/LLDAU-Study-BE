package com.lielion.PBL.assignment.controller;

import com.lielion.PBL.assignment.domain.Assignment;
import com.lielion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lielion.PBL.assignment.dto.AssignmentResponse;
import com.lielion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lielion.PBL.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request
    ) {
        Assignment assignment = assignmentService.createAssignment(memberId, request);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(AssignmentResponse.from(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findAssignmentsByMember(@PathVariable Long memberId) {
        List<AssignmentResponse> assignments = assignmentService.findAssignmentsByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::from)
                .toList();

        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findAssignment(@PathVariable Long id) {
        Assignment assignment = assignmentService.findAssignmentById(id);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request
    ) {
        Assignment assignment = assignmentService.updateAssignment(id, request);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        if (!assignmentService.deleteAssignment(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
