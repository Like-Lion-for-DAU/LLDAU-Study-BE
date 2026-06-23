package com.springbootbackend.lionspringboot.dto;


import com.springbootbackend.lionspringboot.domain.role.Member;

//record는 자바 16부터 정식 도입된, 데이터를 담기만 하는 클래스를 짧게 쓰는 문법
public record MemberResponse(
        Long id,
        String name,
        String major,
        int generation,
        String part,
        String roleName,
        String studentId,
        String position
) {
    // 엔티티(Member)를 응답 DTO(MemberResponse)로 변환하는 메서드
    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getMajor(),
                member.getGeneration(),
                member.getPart(),
                member.getRoleType().getDisplayName(),  // "아기사자" / "운영진"
                member.getStudentId(),
                member.getPosition()
        );
    }
}