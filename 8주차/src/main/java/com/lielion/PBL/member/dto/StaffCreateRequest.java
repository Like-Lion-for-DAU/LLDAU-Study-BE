package com.lielion.PBL.member.dto;

import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.domain.RoleType;

public class StaffCreateRequest {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String position;

    public StaffCreateRequest() {
    }

    public Member toEntity() {
        return new Member(name, major, generation, part, RoleType.STAFF, null, position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
