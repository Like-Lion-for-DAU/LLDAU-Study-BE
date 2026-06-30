package com.example.demo.class5.dto;

import com.example.demo.class5.domain.Member;
import com.example.demo.class5.domain.RoleType;

public class LionCreateRequest {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;

    public LionCreateRequest() {
    }

    public LionCreateRequest(String name, String major, int generation, String part, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
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

    public String getStudentId() {
        return studentId;
    }


}