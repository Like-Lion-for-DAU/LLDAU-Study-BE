package com.example.demo.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StaffUpdateRequest {
    String major;
    int generation;
    String part;
    String position;
}
