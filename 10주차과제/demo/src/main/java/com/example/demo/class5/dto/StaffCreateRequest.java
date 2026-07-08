package com.example.demo.class5.dto;

import com.example.demo.class5.domain.Member;
import com.example.demo.class5.domain.RoleType;

public class StaffCreateRequest {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;
    private String position;

    public StaffCreateRequest() {
    }

    public StaffCreateRequest(String name, String major, int generation, String part, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.position = position;
    }

    public Member toEntity() {
        return new Member(
                name,
                major,
                part,
                generation,
                RoleType.STAFF,
                null,
                position
        );

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

    public String getPosition() {
        return position;
    }
}
