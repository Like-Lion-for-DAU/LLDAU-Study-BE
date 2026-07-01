package com.lielion.PBL.assignment.dto;

import com.lielion.PBL.assignment.domain.Assignment;

public class AssignmentResponse {
	private Long id;
	private String title;
	private String description;
	private Long memberId;
	private String memberName;

	public AssignmentResponse() {
	}

	public AssignmentResponse(Long id, String title, String description, Long memberId, String memberName) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public static AssignmentResponse from(Assignment assignment) {
		return new AssignmentResponse(
			assignment.getId(),
			assignment.getTitle(),
			assignment.getDescription(),
			assignment.getMember().getId(),
			assignment.getMember().getName()
		);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
