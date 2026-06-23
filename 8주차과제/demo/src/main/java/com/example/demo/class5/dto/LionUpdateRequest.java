package com.example.demo.class5.dto;

import com.example.demo.class5.domain.Member;
import com.example.demo.class5.domain.RoleType;

public class LionUpdateRequest {

    private String major;
    private int generation;
    private String part;
    private String studentId;
    private String name;

    public LionUpdateRequest() {
    }

    public LionUpdateRequest(String major, int generation, String part, String studentId, String name) {
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.name = name;
    }

    public Member toEntity() {
        return new Member(
                name,
                major,
                part,
                generation,
                RoleType.LION,
                studentId,
                null
        );

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

    public String getStudentId() {
        return studentId;
    }
}