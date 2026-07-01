package com.example.demo.controller;

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(
            @RequestParam Long memberId,
            @RequestParam String title) {
        return ResponseEntity.ok(assignmentService.createAssignment(memberId, title));
    }
}