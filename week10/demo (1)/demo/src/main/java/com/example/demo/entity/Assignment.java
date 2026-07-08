package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Assignment() {}

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Member getMember() { return member; }

    // Member와의 안전한 양방향 연결을 위한 Setter
    public void setMember(Member member) {
        this.member = member;
        if (member != null && !member.getAssignments().contains(this)) {
            member.getAssignments().add(this);
        }
    }
}