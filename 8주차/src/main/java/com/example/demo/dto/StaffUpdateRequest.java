package com.example.demo.dto;

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
