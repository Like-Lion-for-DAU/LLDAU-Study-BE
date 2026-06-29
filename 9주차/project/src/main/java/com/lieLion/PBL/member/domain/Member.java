package com.lieLion.PBL.member.domain;

import com.lieLion.PBL.assignment.domain.Assignment;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private Integer generation;   // Lion용
    private String department;    // Staff용

    @OneToMany(mappedBy = "member")
    private List<Assignment> assignments = new ArrayList<>();

    protected Member() {}

    // Lion 생성자
    public Member(String name, String email, RoleType role, Integer generation) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.generation = generation;
    }

    // Staff 생성자
    public Member(String name, String email, RoleType role, String department) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.department = department;
    }

    public void updateLion(String name, String email, Integer generation) {
        this.name = name;
        this.email = email;
        this.generation = generation;
    }

    public void updateStaff(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public RoleType getRole() { return role; }
    public Integer getGeneration() { return generation; }
    public String getDepartment() { return department; }
    public List<Assignment> getAssignments() { return assignments; }
}
