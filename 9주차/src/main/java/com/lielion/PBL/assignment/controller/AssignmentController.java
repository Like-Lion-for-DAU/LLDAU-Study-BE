package com.lielion.PBL.assignment.controller;

import com.lielion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lielion.PBL.assignment.dto.AssignmentResponse;
import com.lielion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lielion.PBL.assignment.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members/{memberId}/assignments")
public class AssignmentController {
	private final AssignmentService assignmentService;

	public AssignmentController(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@PostMapping
	public ResponseEntity<AssignmentResponse> createAssignment(
		@PathVariable Long memberId,
		@RequestBody AssignmentCreateRequest request) {
		AssignmentResponse response = assignmentService.createAssignment(memberId, request);
		if (response == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(201).body(response);
	}

	@GetMapping
	public ResponseEntity<List<AssignmentResponse>> getAssignmentsByMember(@PathVariable Long memberId) {
		List<AssignmentResponse> assignments = assignmentService.getAssignmentsByMemberId(memberId);
		return ResponseEntity.ok(assignments);
	}
}

@RestController
@RequestMapping("/assignments")
class AssignmentDetailController {
	private final AssignmentService assignmentService;

	public AssignmentDetailController(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssignmentResponse> getById(@PathVariable Long id) {
		AssignmentResponse assignment = assignmentService.getById(id);
		if (assignment == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(assignment);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AssignmentResponse> updateAssignment(
		@PathVariable Long id,
		@RequestBody AssignmentUpdateRequest request) {
		AssignmentResponse assignment = assignmentService.updateAssignment(id, request);
		if (assignment == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(assignment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
		assignmentService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
