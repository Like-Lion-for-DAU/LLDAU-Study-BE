package com.lilelion.PBL.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LionCreateRequest {
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String studentId;
}
