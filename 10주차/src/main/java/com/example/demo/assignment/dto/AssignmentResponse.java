package com.example.demo.assignment.dto;

import com.example.demo.assignment.domain.Assignment;
import com.example.demo.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AssignmentResponse {
    private Long id;
    private String title;
    private String description;
    private Long memberId;
    private String memberName;

    public static AssignmentResponse from(Assignment assignment) {
        Member member = assignment.getMember();

        return new AssignmentResponse(
                assignment.getId(),
                assignment.getTitle(),
                assignment.getDescription(),
                member.getId(),
                member.getName()
        );
    }
}
