package com.example.demo.assignment.controller;

import com.example.demo.assignment.domain.Assignment;
import com.example.demo.assignment.service.AssignmentService;
import com.example.demo.assignment.dto.AssignmentCreateRequest;
import com.example.demo.assignment.dto.AssignmentResponse;
import com.example.demo.assignment.dto.AssignmentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<?> createAssignment(@PathVariable Long memberId, @RequestBody AssignmentCreateRequest request){
        Assignment assignment = assignmentService.createAssignment(memberId, request);
        if(assignment == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(AssignmentResponse.from(assignment));

    }
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<?> getAssignment(@PathVariable Long memberId){
        List<AssignmentResponse> response = assignmentService.findByMemberId(memberId)
                .stream()
                .map(assignment -> AssignmentResponse.from(assignment))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<?> getAssignmentById(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long id, @RequestBody AssignmentUpdateRequest request) {
        Assignment assignment = assignmentService.updateAssignment(id, request);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long id) {
        boolean isDeleted = assignmentService.deleteAssignment(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
