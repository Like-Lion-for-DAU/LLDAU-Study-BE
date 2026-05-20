package com.example.pbl.role;

import com.example.pbl.policy.SubmitPolicy;

public abstract class Role {

    // 공통 필드, 직접 접근 불가함
    private String name;
    private String major;
    private int generation;
    private String part;

    // 생성자 : 공통 정보 초기화(객체 만들 때 기본 정보들을 처음에 세팅)
    public Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    // 정책 객체 반환 (각 하위 클래스에서 구현함)
    protected abstract SubmitPolicy getPolicy();

    // 과제 제출 가능 여부 판단 (Main에서 로직 금지 조건 만족)
    public boolean canSubmitAssignment() {
        return getPolicy().canSubmit();
    }

    // 자식 클래스에서 사용 가능하도록 getter 제공
    public String getName() { return name; }
    protected String getMajor() { return major; }
    protected int getGeneration() { return generation; }
    protected String getPart() { return part; }

    //역할 이름 (instanceof 제거)
    public abstract String getRoleName();

    // 역할별 상세 정보 출력
    public abstract String getInfo();
}