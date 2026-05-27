package com.likelion.domain.role;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part, "운영진");
        this.position = position;
    }

    public String getPosition() { return position; }

    public void updateStaffInfo(String major, int generation, String part, String position) {
        super.updateCommonInfo(major, generation, part);
        this.position = position;
    }
}