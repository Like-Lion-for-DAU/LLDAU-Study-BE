package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // N:1 관계 설정 (DB에 member_id 외래 키 컬럼 생성)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Assignment() {}

    public Assignment(String title, Member member) {
        this.title = title;
        this.member = member;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
}
