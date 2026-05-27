package com.likelion.domain.role;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part, "아기사자");
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    public void updateLionInfo(String major, int generation, String part, String studentId) {
        super.updateCommonInfo(major, generation, part);
        this.studentId = studentId;
    }
}