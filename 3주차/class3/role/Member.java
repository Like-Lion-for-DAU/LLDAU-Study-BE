package class3.role;

import class3.policy.AssignmentPolicy;

public abstract class Member {
    private String name;
    private String major;
    private int ordinal;
    private String part;

    public Member(String name, String major, int ordinal, String part) {
        this.name = name;
        this.major = major;
        this.ordinal = ordinal;
        this.part = part;
    }

    // 공통 정보 출력용 Getter (하위 클래스에서 사용)
    protected String getCommonInfo() {
        return String.format(" 이름: %s 전공: %s 기수: %d 파트: %s", 
                name, major, ordinal, part);
    }

    // 추상 메서드: 하위 클래스에서 구체화
    public abstract String getRoleName();
    public abstract String getDetailInfo();
    public abstract AssignmentPolicy getPolicy();

    // 다형성 활용: Main에서 이 메서드만 호출하면 됨
    public void printInfo() {
        System.out.println("역할: " + getRoleName());
        System.out.println(getDetailInfo());
        String status = getPolicy().canSubmit() ? "가능" : " 불가능";
        System.out.println("과제 제출 가능 여부: " + status);
        System.out.println("---------------------------------------");
    }
}