package com.example.pbl.domain.role;


public class Staff extends Role {

    private String position;
    //생성자
    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    //운영진은 과제 제출 불가
    @Override
    public boolean canSubmitAssignment() {
        return false;
    }

    //역할 이름 반환
    @Override
    public String getRoleName() {
        return "운영진";
    }
    //운영진 정보 출력
    @Override
    public String getInfo() {
        return "👤 이름: " + getName() +
                "\n⭐ 직책: " + position;
    }
}
