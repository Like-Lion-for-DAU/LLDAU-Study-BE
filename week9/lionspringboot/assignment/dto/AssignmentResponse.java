package com.springbootbackend.lionspringboot.assignment.dto;

import com.springbootbackend.lionspringboot.assignment.domain.Assignment;

// memberId와 memberName. 이건 Assignment가 가진 게 아니라, Assignment가 참조하는 Member에서 꺼내온다
public record AssignmentResponse(
        Long id,
        String title,
        String description,
        Long memberId,
        String memberName
) {
    public static AssignmentResponse from(Assignment assignment) {
        return new AssignmentResponse(
                assignment.getId(),
                assignment.getTitle(),
                assignment.getDescription(),
                assignment.getMember().getId(),      // 참조하는 Member에서 가져옴
                assignment.getMember().getName()
        );
    }
}
