package com.lilelion.PBL.assignment.domain;

import com.lilelion.PBL.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Assignment(String title, String description, Member member) {
        this.title = title;
        this.description = description;
        this.member = member;
    }

    public static Assignment create(String title, String description, Member member) {
        return Assignment.builder()
                .title(title)
                .description(description)
                .member(member)
                .build();
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
