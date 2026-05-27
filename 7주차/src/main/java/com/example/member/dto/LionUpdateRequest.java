package com.example.member.dto;

import com.example.member.domain.role.Lion;

public class LionUpdateRequest {
    private String major;
    private int generation;
    private String part;
    private String studentId;

    public LionUpdateRequest() {
    }

    public Lion toEntity(String name) {
        return new Lion(name, major, generation, part, studentId);
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
