package com.example.pbl.role;

import com.example.pbl.policy.LionSubmitPolicy;
import com.example.pbl.policy.SubmitPolicy;


public class Lion extends Role {

    private String studentId;
    //생성자
    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }
    //아기사자 정책 반환
    @Override
    protected SubmitPolicy getPolicy() {
        return new LionSubmitPolicy();
    }
    //역할 이름 반환
    @Override
    public String getRoleName() {
        return "아기사자";
    }
    //아기사자 정보 출력
    @Override
    public String getInfo() {
        return "👤 이름: " + getName() +
                " | 🎓 전공: " + getMajor() +
                " | 📌 기수: " + getGeneration() +
                " | 💻 파트: " + getPart() +
                "\n🆔 학번: " + studentId;
    }
}