package com.example.demo.domain;

public class Staff extends Member {
    private String position;

    public Staff(Long id, String name, String position) {
        super(id, name, "STAFF");
        this.position = position;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}