package com.lilelion.PBL.member.dto;

import com.lilelion.PBL.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {

    private final Long id;
    private final String name;
    private final String major;
    private final Integer generation;
    private final String part;
    private final String roleName;
    private final String studentId;
    private final String position;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.major = member.getMajor();
        this.generation = member.getGeneration();
        this.part = member.getPart();
        this.roleName = member.getRoleName();
        this.studentId = member.getStudentId();
        this.position = member.getPosition();
    }
}
