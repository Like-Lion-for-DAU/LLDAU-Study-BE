package com.example.demo.member.dto;

import com.example.demo.member.domain.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LionCreateRequest {
    String name;
    String major;
    String part;
    int generation;
    RoleType roleType;
    String studentId;
}
