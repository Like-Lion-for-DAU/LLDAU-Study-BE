package com.example.demo.domain;

public class Lion extends Member {
    private String studentId;

    public Lion(Long id, String name, String studentId) {
        super(id, name, "LION");
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
}