package week3.member;

import week3.policy.AssignmentPolicy;

public abstract class Member {
    protected String name;
    protected String major;
    protected int year;
    protected String part;

    public Member(String name, String major, int year, String part) {
        this.name = name;
        this.major = major;
        this.year = year;
        this.part = part;
    }

    // 정책 객체 반환 (하위 클래스에서 구현)
    protected abstract AssignmentPolicy getPolicy();

    // 상세 정보 반환 (하위 클래스에서 구현)
    public abstract String getDetails();

    // 과제 제출 여부 판단 (정책 객체에 위임)
    public boolean canSubmitAssignment() {
        return getPolicy().canSubmit();
    }
}
