package Class5.role;

import Class5.policy.AssignmentPolicy;
import Class5.policy.LionSubmissionPolicy;

public class Lion extends Role {
    private String number;

    public Lion(String name, String major, int generation, String part, String number) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.number = number;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public void getInfo() {
        System.out.println("이름: " + name + ", 전공: " + major + ", 기수: " + generation + ", 파트: " + part + ", 학번: " + number);
    }
}
