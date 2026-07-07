package com.lilelion.PBL.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private Integer generation;
    private String part; // 프론트엔드 / 백엔드 / 기획 등

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private String roleName; // 화면에 표시되는 역할명 (아기사자 / 운영진 등)

    private String studentId; // LION(교육생) 전용
    private String position;  // STAFF(운영진) 전용 직책

    @Builder
    private Member(String name, String major, Integer generation, String part,
                    RoleType role, String roleName, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.role = role;
        this.roleName = roleName;
        this.studentId = studentId;
        this.position = position;
    }

    public static Member createLion(String name, String major, Integer generation,
                                     String part, String studentId) {
        return Member.builder()
                .name(name)
                .major(major)
                .generation(generation)
                .part(part)
                .role(RoleType.LION)
                .roleName("아기사자")
                .studentId(studentId)
                .position(null)
                .build();
    }

    public static Member createStaff(String name, String major, Integer generation,
                                      String part, String position) {
        return Member.builder()
                .name(name)
                .major(major)
                .generation(generation)
                .part(part)
                .role(RoleType.STAFF)
                .roleName("운영진")
                .studentId(null)
                .position(position)
                .build();
    }

    public void updateLion(String name, String major, Integer generation, String part, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    public void updateStaff(String name, String major, Integer generation, String part, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }
}
