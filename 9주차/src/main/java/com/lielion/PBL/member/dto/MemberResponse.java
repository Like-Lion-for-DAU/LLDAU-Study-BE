package com.lielion.PBL.member.dto;

import com.lielion.PBL.member.domain.Member;

public class MemberResponse {
	private Long id;
	private String name;
	private String major;
	private int generation;
	private String part;
	private String roleName;
	private String studentId;
	private String position;

	public MemberResponse() {
	}

	public MemberResponse(Long id, String name, String major, int generation, String part, String roleName, String studentId, String position) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.generation = generation;
		this.part = part;
		this.roleName = roleName;
		this.studentId = studentId;
		this.position = position;
	}

	public static MemberResponse from(Member member) {
		return new MemberResponse(
			member.getId(),
			member.getName(),
			member.getMajor(),
			member.getGeneration(),
			member.getPart(),
			member.getRoleType().getDisplayName(),
			member.getStudentId(),
			member.getPosition()
		);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
