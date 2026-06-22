package com.example.demo.dto;

import com.example.demo.domain.RoleType;
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
