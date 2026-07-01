package com.lielion.PBL.member.domain;

import jakarta.persistence.*;
import com.lielion.PBL.assignment.domain.Assignment;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String major;

	@Column(nullable = false)
	private int generation;

	@Column(nullable = false)
	private String part;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	private String studentId;

	private String position;

	@OneToMany(mappedBy = "member")
	private List<Assignment> assignments = new ArrayList<>();

	protected Member() {
	}

	public Member(String name, String major, int generation, String part, RoleType roleType, String studentId, String position) {
		this.name = name;
		this.major = major;
		this.generation = generation;
		this.part = part;
		this.roleType = roleType;
		this.studentId = studentId;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getGeneration() {
		return generation;
	}

	public String getPart() {
		return part;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getPosition() {
		return position;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void updateInfo(String name, String major, int generation, String part) {
		this.name = name;
		this.major = major;
		this.generation = generation;
		this.part = part;
	}

	public void updateStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void updatePosition(String position) {
		this.position = position;
	}
}
