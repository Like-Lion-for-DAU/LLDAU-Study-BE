package com.example.week6.role;

public class Staff extends Role {

    private String position;

    public Staff(String name, String major, int batch, String part, String position) {
        super(name, major, batch, part);
        this.position = position;
    }

    @Override
    public String getInfo() {
        return "[운영진]\n" +
                getBasicInfo() +
                "\n직책: " + position;
    }
}