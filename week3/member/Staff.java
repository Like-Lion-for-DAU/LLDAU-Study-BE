package week3.member;


import week3.policy.AssignmentPolicy;
import week3.policy.StaffPolicy;

public class Staff extends Member {
    private String position;

    public Staff(String name, String major, int year, String part, String position) {
        super(name, major, year, part);
        this.position = position;
    }

    @Override
    protected AssignmentPolicy getPolicy() {
        return new StaffPolicy();
    }

    @Override
    public String getDetails() {
        return String.format(
                "🎭 역할: 운영진\n" +
                        "👤 이름: %s  |  🎓 전공: %s  |  📌 기수: %d  |  💻 파트: %s\n" +
                        "⭐ 직책: %s",
                name, major, year, part, position);
    }
}
