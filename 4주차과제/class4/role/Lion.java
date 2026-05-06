package class4.role;

import class4.policy.policyLion;
import class4.policy.policyinter;

public class Lion extends wlq {
    public String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public policyinter getPolicy() {
        return new policyLion();
    }

    @Override
    public String getInfo() {
        return "🎭 역할 : 아기사자" +
            "\n👤 이름: " + getName() +
            " | 🎓 전공: " + getMajor() +
            " | 📌 기수: " + getGeneration() +
            " | 💻 파트: " + getPart() +
            "\n🆔 학번: " + studentId;
    }
}