package com.example.demo.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StaffCreateRequest {
    String name;
    String major;
    int generation;
    String part;
    String position;
}
