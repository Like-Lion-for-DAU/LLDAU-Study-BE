package com.likelion.dto;

public record StaffUpdateRequest(
        String major,
        int generation,
        String part,
        String position
) {}