package com.springbootbackend.lionspringboot.domain.role;



public enum RoleType {
    //RoleType이 가질 수 있는 값은 이 두 개로 못박힙니다. 괄호 안의 "아기사자"는 각 상수에 딸린 추가 정보
    //값이 제한된다는 게 가장 큰 장점입니다. LION, STAFF 외의 값은 들어올 수 없어 데이터 오염이 방지
    LION("아기사자"),
    STAFF("운영진");

    private final String displayName;

    RoleType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
