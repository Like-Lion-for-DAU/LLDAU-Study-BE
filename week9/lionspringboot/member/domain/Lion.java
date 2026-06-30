//package com.springbootbackend.lionspringboot.domain.role;
//
//
//public class Lion implements Role {
//    private String name;
//    private String major;
//    private int generation;
//    private String part;
//    private String studentId;   // Lion 고유 필드
//
//    public Lion(String name, String major, int generation, String part, String studentId) {
//        this.name = name;
//        this.major = major;
//        this.generation = generation;
//        this.part = part;
//        this.studentId = studentId;
//    }
//
//    @Override public String getName() { return name; }
//    @Override public String getMajor() { return major; }
//    @Override public int getGeneration() { return generation; }
//    @Override public String getPart() { return part; }
//    @Override public String getRoleType() { return "아기사자"; }
//    @Override public boolean canSubmit() { return true; }
//
//    public String getStudentId() { return studentId; }
//
//    // 수정(PUT)용 setter — name은 식별자이므로 변경하지 않음
//    public void setMajor(String major) { this.major = major; }
//    public void setGeneration(int generation) { this.generation = generation; }
//    public void setPart(String part) { this.part = part; }
//    public void setStudentId(String studentId) { this.studentId = studentId; }
//
//    @Override
//    public String toString() {
//        return "역할: " + getRoleType() + "\n" +
//                "이름: " + name + " | 전공: " + major +
//                " | 기수: " + generation + " | 파트: " + part + "\n" +
//                "학번: " + studentId + "\n" +
//                "과제 제출 가능: ✅ 가능";
//    }
//}