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
        return ResponseEntity.status(HttpStatus.CREATED).body(AssignmentResponse.from(assignment));

    }
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<?> getAssignment(@PathVariable Long memberId){
        List<AssignmentResponse> response = assignmentService.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/assignments")
    public ResponseEntity<?> getAllAssignments() {
        List<AssignmentResponse> response = assignmentService.findAll()
                .stream()
                .map(AssignmentResponse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/assignments/search")
    public ResponseEntity<?> searchAssignments(@RequestParam String keyword) {
        List<AssignmentResponse> response = assignmentService.searchByTitle(keyword)
                .stream()
                .map(AssignmentResponse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<?> getAssignmentById(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long id, @RequestBody AssignmentUpdateRequest request) {
        Assignment assignment = assignmentService.updateAssignment(id, request);

        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);

        return ResponseEntity.noContent().build();
    }

}
