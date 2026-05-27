package com.example.demo.domain;

public abstract class Member {
    private Long id;
    private String name;
    private String type;

    public Member(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public String getType() { return type; }
}