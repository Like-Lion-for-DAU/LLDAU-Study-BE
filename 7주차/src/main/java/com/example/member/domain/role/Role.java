package com.example.member.domain.role;

public abstract class Role {
    protected String name;
    protected String major;
    protected int generation;
    protected String part;

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }
}
