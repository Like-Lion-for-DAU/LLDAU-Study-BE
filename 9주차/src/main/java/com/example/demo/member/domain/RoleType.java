package com.example.demo.member.domain;

public enum RoleType {
    LION("아기사자"),
    STAFF("운영진");


    private final String displayname;

    RoleType(String displayname) {
        this.displayname = displayname;
    }

    public String getDisplayname(){
        return displayname;
    }
}
