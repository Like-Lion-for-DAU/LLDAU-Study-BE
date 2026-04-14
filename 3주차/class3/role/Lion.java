package class3.role;

import class3.policy.AssignmentPolicy;
import class3.policy.LionAssignmentPolicy;

public class Lion extends Member {
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
}