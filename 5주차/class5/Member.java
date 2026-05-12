package class5;

import class5.role.Role;
import class5.policy.AssignmentPolicy;

public class Member {
    private String name;
    private String major;
    private int term;
    private String part;
    private String studentId;
    private Role role;
    private AssignmentPolicy policy;

    public Member(String name, String major, int term, String part, String studentId, Role role, AssignmentPolicy policy) {
        this.name = name;
        this.major = major;
        this.term = term;
        this.part = part;
        this.studentId = studentId;
        this.role = role;
        this.policy = policy;
    }

    public String getName() { return name; }
    public Role getRole() { return role; }
    public AssignmentPolicy getPolicy() { return policy; }

    @Override
    public String toString() {
        return String.format("---------------------------------------\n" +
                        "역할: %s\n" +
                        "이름: %s | 전공: %s\n" +
                        "기수: %d | 파트: %s\n" +
                        "학번: %s\n" +
                        "과제 제출 가능: %s\n" +
                        "---------------------------------------",
                role.getRoleName(), name, major, term, part, studentId, 
                policy.canSubmit() ? "가능" : "불가능");
    }
}