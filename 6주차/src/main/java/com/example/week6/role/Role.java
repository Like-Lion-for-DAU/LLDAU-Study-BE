package com.example.week6.role;

public abstract class Role {

    private String name;
    private String major;
    private int batch;
    private String part;

    public Role(String name, String major, int batch, String part) {
        this.name = name;
        this.major = major;
        this.batch = batch;
        this.part = part;
    }

    public String getName() {
        return name;
    }

    protected String getBasicInfo() {
        return "이름: " + name +
                " | 전공: " + major +
                " | 기수: " + batch +
                " | 파트: " + part;
    }

    public abstract String getInfo();
}