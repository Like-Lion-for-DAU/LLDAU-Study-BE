package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LionUpdateRequest {
    String major;
    int generation;
    String part;
    int studentId;
}
