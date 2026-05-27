package com.example.week7.dto;

import com.example.week7.role.Staff;

public class StaffResponse {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String position;

    public StaffResponse(
            String name,
            String major,
            int generation,
            String part,
            String roleName,
            String position
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.position = position;
    }

    public static StaffResponse from(Staff staff) {
        return new StaffResponse(
                staff.getName(),
                staff.getMajor(),
                staff.getGeneration(),
                staff.getPart(),
                staff.getRoleName(),
                staff.getPosition()
        );
    }
}