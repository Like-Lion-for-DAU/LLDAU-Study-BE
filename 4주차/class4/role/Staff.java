package class4.role;

import class4.policy.AssignmentPolicy;
import class4.policy.StaffAssignmentPolicy;

public class Staff extends Role {
    private String position;
    private String email;

    public Staff(String name, String major, int ordinal, String part, String position) {
        super(name, major, ordinal, part);
        this.position = position;
    }

    @Override
    public String getRoleName() { return "운영진"; }

    @Override
    public String getDetailInfo() {
        return getCommonInfo() + "\n 직책: " + position;
    }

    @Override
    public AssignmentPolicy getPolicy() {
        return new StaffAssignmentPolicy();
    }
    @Override
    public String toString() {
        return "👤 [운영진] 이름: " + getName() + 
               " | 전공: " + getMajor() + 
               " | 파트: " + getPart() + 
               " | 이메일: " + email;
    }
}