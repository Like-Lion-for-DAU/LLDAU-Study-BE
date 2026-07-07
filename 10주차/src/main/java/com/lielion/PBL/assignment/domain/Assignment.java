package com.lielion.PBL.assignment.domain;

import jakarta.persistence.*;
import com.lielion.PBL.member.domain.Member;

@Entity
@Table(name = "assignment")
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	private String description;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	protected Assignment() {
	}

	public Assignment(String title, String description, Member member) {
		this.title = title;
		this.description = description;
		this.member = member;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Member getMember() {
		return member;
	}

	public void updateInfo(String title, String description) {
		this.title = title;
		this.description = description;
	}
}