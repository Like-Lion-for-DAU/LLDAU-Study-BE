package com.example.week6.role;

public class Lion extends Role {

    private String studentId;

    public Lion(String name, String major, int batch, String part, String studentId) {
        super(name, major, batch, part);
        this.studentId = studentId;
    }

    @Override
    public String getInfo() {
        return "[아기사자]\n" +
                getBasicInfo() +
                "\n학번: " + studentId;
    }
}