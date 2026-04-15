package week3.member;


import week3.policy.AssignmentPolicy;
import week3.policy.LionPolicy;

public class Lion extends Member {
    private String studentId;

    public Lion(String name, String major, int year, String part, String studentId) {
        super(name, major, year, part);
        this.studentId = studentId;
    }

    @Override
    protected AssignmentPolicy getPolicy() {
        return new LionPolicy();
    }

    @Override
    public String getDetails() {
        return String.format(
                "🎭 역할: 아기사자\n" +
                        "👤 이름: %s  |  🎓 전공: %s  |  📌 기수: %d  |  💻 파트: %s\n" +
                        "🆔 학번: %s",
                name, major, year, part, studentId);
    }
}