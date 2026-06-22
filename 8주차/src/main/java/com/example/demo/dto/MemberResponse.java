package com.example.demo.dto;

import com.example.demo.domain.Member;
import com.example.demo.domain.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String name;
    private String major;
    private int generation;
    private String part;
    private RoleType roleName;
    private String studentId;
    private String position;

    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getMajor(),
                member.getGeneration(),
                member.getPart(),
                member.getRoleType(),
                member.getStudentId(),
                member.getPosition()
        );
    }
}
