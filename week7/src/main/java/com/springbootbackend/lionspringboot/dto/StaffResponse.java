package com.springbootbackend.lionspringboot.dto;


import com.springbootbackend.lionspringboot.domain.role.Staff;


public record StaffResponse(
        String name,
        String major,
        int generation,
        String part,
        String roleName,
        String position
) {
    public static StaffResponse from(Staff staff) {
        return new StaffResponse(
                staff.getName(),
                staff.getMajor(),
                staff.getGeneration(),
                staff.getPart(),
                staff.getRoleType(),   // "운영진"
                staff.getPosition()
        );
    }
}
