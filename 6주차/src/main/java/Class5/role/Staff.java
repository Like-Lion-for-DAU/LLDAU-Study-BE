package Class5.role;

import Class5.policy.AssignmentPolicy;
import Class5.policy.StaffSubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public void getInfo() {
        System.out.println("이름: " + name + ", 전공: " + major + ", 기수: " + generation + ", 파트: " + part + ", 직책: " + position);
    }
}
