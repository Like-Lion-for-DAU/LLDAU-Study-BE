package com.likelion.dto;

public record LionUpdateRequest(
        String major,
        int generation,
        String part,
        String studentId
) {}