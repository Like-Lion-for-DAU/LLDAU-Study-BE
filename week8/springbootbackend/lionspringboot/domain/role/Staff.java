//package com.springbootbackend.lionspringboot.domain.role;
//
//
//public class Staff implements Role {
//    private String name;
//    private String major;
//    private int generation;
//    private String part;
//    private String position;   // Staff 고유 필드 (직책: 대표, 부대표 등)
//
//    public Staff(String name, String major, int generation, String part, String position) {
//        this.name = name;
//        this.major = major;
//        this.generation = generation;
//        this.part = part;
//        this.position = position;
//    }
//
//    @Override public String getName() { return name; }
//    @Override public String getMajor() { return major; }
//    @Override public int getGeneration() { return generation; }
//    @Override public String getPart() { return part; }
//    @Override public String getRoleType() { return "운영진"; }
//    @Override public boolean canSubmit() { return false; }
//
//    public String getPosition() { return position; }
//
//    // 수정(PUT)용 setter — name은 식별자이므로 변경하지 않음
//    public void setMajor(String major) { this.major = major; }
//    public void setGeneration(int generation) { this.generation = generation; }
//    public void setPart(String part) { this.part = part; }
//    public void setPosition(String position) { this.position = position; }
//
//    @Override
//    public String toString() {
//        return "역할: " + getRoleType() + "\n" +
//                "이름: " + name + " | 전공: " + major +
//                " | 기수: " + generation + " | 파트: " + part + "\n" +
//                "직책: " + position + "\n" +
//                "과제 제출 가능: ❌ 불가";
//    }
//}