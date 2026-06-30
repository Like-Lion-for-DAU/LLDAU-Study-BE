package com.example.demo.class5.assignment.controller;

import com.example.demo.class5.assignment.dto.AssignmentCreateRequest;
import com.example.demo.class5.assignment.dto.AssignmentResponse;
import com.example.demo.class5.assignment.dto.AssignmentUpdateRequest;
import com.example.demo.class5.assignment.service.AssignmentService;
import com.example.demo.class5.domain.Assignment;
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

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request
    ) {
        Assignment assignment = assignmentService.create(
                memberId,
                request.getTitle(),
                request.getDescription()
        );

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AssignmentResponse.from(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public List<AssignmentResponse> findByMemberId(@PathVariable Long memberId) {
        return assignmentService.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::from)
                .toList();
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request
    ) {
        Assignment assignment = assignmentService.update(
                id,
                request.getTitle(),
                request.getDescription()
        );

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}