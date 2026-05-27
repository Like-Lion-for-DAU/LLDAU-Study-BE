package com.example.member.domain.role;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
