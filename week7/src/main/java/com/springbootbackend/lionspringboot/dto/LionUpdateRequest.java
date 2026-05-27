package com.springbootbackend.lionspringboot.dto;

//name은 URL 경로(@PathVariable)에서 받으므로 본문에는 포함하지 않는다.
public class LionUpdateRequest {
    private String major;
    private int generation;
    private String part;
    private String studentId;

    public LionUpdateRequest() {}

    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getStudentId() { return studentId; }

    public void setMajor(String major) { this.major = major; }
    public void setGeneration(int generation) { this.generation = generation; }
    public void setPart(String part) { this.part = part; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
}
