package com.springbootbackend.lionspringboot.assignment.domain;

import com.springbootbackend.lionspringboot.member.domain.Member;
import jakarta.persistence.*;

//과제를 표현하는 JPA 엔티티
@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // 과제 제목

    private String description;   // 과제 설명

    //@ManyToOne은 **"이 엔티티가 N쪽이야"**라고 선언. 여러 개의 Assignment가 하나의 Member에 속하니까, Assignment가 N쪽.
    @ManyToOne                                  // 이 엔티티가 N쪽
    @JoinColumn(name = "member_id")             // assignment 테이블에 member_id 외래 키 컬럼 생성
    private Member member;

    // JPA 필수: 기본 생성자 (외부에서 막기 위해 protected)
    protected Assignment() {
    }

    // 생성용 생성자
    public Assignment(String title, String description, Member member) {
        this.title = title;
        this.description = description;
        this.member = member;
    }

    // 수정용 메서드
    public void updateInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Member getMember() {
        return member;
    }
}