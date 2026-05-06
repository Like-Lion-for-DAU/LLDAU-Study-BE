package class4.role;

import class4.policy.policyStaff;
import class4.policy.policyinter;

public class Staff extends wlq {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public policyinter getPolicy() {
        return new policyStaff();
    }

    @Override
    public String getInfo() {
        return "🎭 역할: 운영진 \n" +
                "\n👤 이름: " + getName() +
               " | 🎓 전공: " + getMajor() +
               " | 📌 기수: " + getGeneration() +
               " | 💻 파트: " + getPart() +
               "\n⭐️ 직책: " + position;
    }
}