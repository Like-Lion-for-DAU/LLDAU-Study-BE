package com.example.demo;

import com.example.demo.role.Role;
import com.example.demo.policy.AssignmentPolicy;

public class Member {
    private String name;
    private String major;
    private int term;
    private String part;
    private String studentId;
    private Role role;
    private AssignmentPolicy policy;

    public Member(String name, String major, int term, String part, String studentId, Role role, AssignmentPolicy policy) {
        this.name = name;
        this.major = major;
        this.term = term;
        this.part = part;
        this.studentId = studentId;
        this.role = role;
        this.policy = policy;
    }

    public String getName() { return name; }
    public Role getRole() { return role; }
}