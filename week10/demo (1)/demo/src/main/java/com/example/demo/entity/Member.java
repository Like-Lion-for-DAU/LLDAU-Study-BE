package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 💡 1. 여기에 assignments 변수명이 빠져있던 문제를 수정했습니다.
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assignment> assignments = new ArrayList<>();

    public Member() {}

    public Member(String name) {
        this.name = name;
    }

    // 💡 2. 파라미터 자리에 변수명(assignment)이 빠져있던 문제를 수정했습니다.
    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
        if (assignment.getMember() != this) {
            assignment.setMember(this);
        }
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Assignment> getAssignments() { return assignments; }
}