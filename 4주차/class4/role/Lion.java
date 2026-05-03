package class4.role;

import class4.policy.AssignmentPolicy;
import class4.policy.LionAssignmentPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int ordinal, String part, String studentId) {
        super(name, major, ordinal, part);
        this.studentId = studentId;
    }

    @Override
    public String getRoleName() { return "아기사자"; }

    @Override
    public String getDetailInfo() {
        return getCommonInfo() + "\n학번: " + studentId;
    }

    @Override
    public AssignmentPolicy getPolicy() {
        return new LionAssignmentPolicy();
    }
    @Override
    public String toString() {
        return "🦁 [아기사자] 이름: " + getName() + 
               " | 전공: " + getMajor() + 
               " | 파트: " + getPart() + 
               " | 학번: " + studentId;
    }
}