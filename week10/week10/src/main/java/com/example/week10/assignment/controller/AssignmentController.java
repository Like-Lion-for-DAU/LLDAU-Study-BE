package com.example.week10.assignment.controller;

import com.example.week10.assignment.domain.Assignment;
import com.example.week10.assignment.dto.AssignmentCreateRequest;
import com.example.week10.assignment.dto.AssignmentResponse;
import com.example.week10.assignment.dto.AssignmentUpdateRequest;
import com.example.week10.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request) {

        Assignment assignment =
                assignmentService.createAssignment(memberId, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AssignmentResponse.from(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public List<AssignmentResponse> findAssignments(
            @PathVariable Long memberId) {

        return assignmentService.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findAssignment(
            @PathVariable Long id) {

        Assignment assignment = assignmentService.findById(id);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                AssignmentResponse.from(assignment));
    }

    @GetMapping
    public List<AssignmentResponse> findAll(){

        return assignmentService.findAll()
                .stream()
                .map(AssignmentResponse::from)
                .toList();

    }

    @GetMapping("/search")
    public List<AssignmentResponse> search(
            @RequestParam String keyword){

        return assignmentService.search(keyword)
                .stream()
                .map(AssignmentResponse::from)
                .toList();

    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request) {

        Assignment assignment =
                assignmentService.updateAssignment(id, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> deleteAssignment(
            @PathVariable Long id) {

        boolean result =
                assignmentService.deleteAssignment(id);

        if (!result) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}