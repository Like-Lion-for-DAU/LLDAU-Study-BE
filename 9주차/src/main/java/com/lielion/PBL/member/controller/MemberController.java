package com.lielion.PBL.member.controller;

import com.lielion.PBL.member.dto.LionCreateRequest;
import com.lielion.PBL.member.dto.LionUpdateRequest;
import com.lielion.PBL.member.dto.MemberResponse;
import com.lielion.PBL.member.dto.StaffCreateRequest;
import com.lielion.PBL.member.dto.StaffUpdateRequest;
import com.lielion.PBL.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/lions")
	public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
		MemberResponse response = memberService.createLion(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/staffs")
	public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
		MemberResponse response = memberService.createStaff(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<MemberResponse>> getAll() {
		List<MemberResponse> members = memberService.getAll();
		return ResponseEntity.ok(members);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemberResponse> getById(@PathVariable Long id) {
		MemberResponse member = memberService.getById(id);
		if (member == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(member);
	}

	@PutMapping("/lions/{id}")
	public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest request) {
		MemberResponse member = memberService.updateLion(id, request);
		if (member == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(member);
	}

	@PutMapping("/staffs/{id}")
	public ResponseEntity<MemberResponse> updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest request) {
		MemberResponse member = memberService.updateStaff(id, request);
		if (member == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(member);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		memberService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
