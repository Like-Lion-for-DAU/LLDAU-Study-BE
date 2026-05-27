package com.springbootbackend.lionspringboot.dto;


import com.springbootbackend.lionspringboot.domain.role.Lion;

//서버 → 클라이언트 로 나가는 데이터.
public record LionResponse(
        String name,
        String major,
        int generation,
        String part,
        String roleName,
        String studentId
) {
    // 정적 팩토리 메서드: Lion 도메인 객체 → LionResponse
    public static LionResponse from(Lion lion) {
        return new LionResponse(
                lion.getName(),
                lion.getMajor(),
                lion.getGeneration(),
                lion.getPart(),
                lion.getRoleType(),   // "아기사자"
                lion.getStudentId()
        );
    }
}
