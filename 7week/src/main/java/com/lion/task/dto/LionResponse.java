package com.lion.task.dto;

import com.lion.task.role.Lion;

public class LionResponse {
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String roleName;
    private String studentId;

    public LionResponse(String name, String major, Integer generation, String part, String roleName, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.studentId = studentId;
    }

    public static LionResponse from(Lion lion) {
        return new LionResponse(lion.getName(), lion.getMajor(), lion.getYear(), lion.getPart(), "아기사자", lion.getNumber());
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public Integer getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getStudentId() {
        return studentId;
    }
}
