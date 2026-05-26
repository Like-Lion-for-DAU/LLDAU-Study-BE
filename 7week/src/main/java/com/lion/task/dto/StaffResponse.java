package com.lion.task.dto;

import com.lion.task.role.Staff;

public class StaffResponse {
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String roleName;
    private String position;

    public StaffResponse(String name, String major, Integer generation, String part, String roleName, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.position = position;
    }

    public static StaffResponse from(Staff staff) {
        return new StaffResponse(staff.getName(), staff.getMajor(), staff.getYear(), staff.getPart(), "운영진", staff.getPosition());
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

    public String getPosition() {
        return position;
    }
}
