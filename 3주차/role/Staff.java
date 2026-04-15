package role;

import policy.StaffSubmitPolicy;
import policy.SubmitPolicy;

public class Staff extends Person {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public SubmitPolicy getSubmitPolicy() {
        return new StaffSubmitPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getDetailInfo() {
        return "이름: " + getName()
                + " | 전공: " + getMajor()
                + " | 기수: " + getGeneration()
                + " | 파트: " + getPart()
                + "\n직책: " + getPosition();
    }
}