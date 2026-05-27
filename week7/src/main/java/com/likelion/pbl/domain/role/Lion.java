package com.likelion.pbl.domain.role;

import com.likelion.pbl.policy.LionSubmissionPolicy;
import com.likelion.pbl.policy.SubmissionPolicy;

public class Lion extends Role {

    private final String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getDetailInfo() {
        return "이름: " + getName()
                + " | 전공: " + getMajor()
                + " | 기수: " + getGeneration()
                + " | 파트: " + getPart()
                + "\n학번: " + getStudentId();
    }
}
