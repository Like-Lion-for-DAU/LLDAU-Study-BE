package com.example.member.dto;

import com.example.member.domain.role.Staff;

public class StaffUpdateRequest {
    private String major;
    private int generation;
    private String part;
    private String position;

    public StaffUpdateRequest() {
    }

    public Staff toEntity(String name) {
        return new Staff(name, major, generation, part, position);
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
