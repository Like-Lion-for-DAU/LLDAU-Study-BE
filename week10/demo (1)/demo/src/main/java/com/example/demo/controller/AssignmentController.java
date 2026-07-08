package com.example.demo.controller;

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
    public ResponseEntity<String> createAssignment(
            @RequestParam Long memberId,
            @RequestParam String title) {

        assignmentService.registerAssignment(memberId, title);
        return ResponseEntity.ok("영속성 전이(Cascade)를 통해 과제가 정상 등록되었습니다.");
    }
}