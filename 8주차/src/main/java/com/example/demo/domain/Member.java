package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private String part;
    private int generation;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String studentId;
    private String position;

    protected Member() {
    }

    public Member(String name, String major, String part, int generation, RoleType roleType, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.part = part;
        this.generation = generation;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

    public void updateInfo(String name, String major, String part, int generation, RoleType roleType) {
        this.name = name;
        this.major = major;
        this.part = part;
        this.generation = generation;
        this.roleType = roleType;
    }

    public void updateStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void updatePosition(String position) {
        this.position = position;
    }
}
