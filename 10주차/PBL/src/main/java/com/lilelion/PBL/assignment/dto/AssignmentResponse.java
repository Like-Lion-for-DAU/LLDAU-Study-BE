package com.lilelion.PBL.assignment.dto;

import com.lilelion.PBL.assignment.domain.Assignment;
import lombok.Getter;

@Getter
public class AssignmentResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final Long memberId;
    private final String memberName;

    public AssignmentResponse(Assignment assignment) {
        this.id = assignment.getId();
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();
        this.memberId = assignment.getMember().getId();
        this.memberName = assignment.getMember().getName();
    }
}
