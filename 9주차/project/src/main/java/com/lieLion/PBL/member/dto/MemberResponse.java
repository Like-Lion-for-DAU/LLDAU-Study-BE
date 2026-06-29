package com.lieLion.PBL.member.dto;

import com.lieLion.PBL.member.domain.Member;
import com.lieLion.PBL.member.domain.RoleType;

public class MemberResponse {
    private Long id;
    private String name;
    private String email;
    private RoleType role;
    private Integer generation;
    private String department;

    private MemberResponse() {}

    public static MemberResponse from(Member member) {
        MemberResponse response = new MemberResponse();
        response.id = member.getId();
        response.name = member.getName();
        response.email = member.getEmail();
        response.role = member.getRole();
        response.generation = member.getGeneration();
        response.department = member.getDepartment();
        return response;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public RoleType getRole() { return role; }
    public Integer getGeneration() { return generation; }
    public String getDepartment() { return department; }
}
