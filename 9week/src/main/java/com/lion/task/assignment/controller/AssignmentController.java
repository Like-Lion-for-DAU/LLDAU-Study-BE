package com.lion.task.assignment.controller;

import com.lion.task.assignment.domain.*;
import com.lion.task.assignment.dto.*;
import com.lion.task.assignment.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(@PathVariable Long memberId, @RequestBody AssignmentCreateRequest request) {
        Assignment assignment = assignmentService.create(memberId, request.getTitle(), request.getDescription());
        if(assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(AssignmentResponse.from(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findAssignments(@PathVariable Long memberId) {
        List<AssignmentResponse> result = new ArrayList<>();
        for (Assignment assignment : assignmentService.findByMemberId(memberId)) {
            result.add(AssignmentResponse.from(assignment));
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findAssignment(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);
        if(assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(@PathVariable Long id, @RequestBody AssignmentUpdateRequest request) {
        Assignment assignment = assignmentService.update(id, request.getTitle(), request.getDescription());
        if(assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(!assignmentService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
