package com.springbootbackend.lionspringboot.dto;

/**
 * Staff 수정 요청 DTO
 * name은 URL 경로(@PathVariable)에서 받으므로 본문에는 포함하지 않는다.
 */
public class StaffUpdateRequest {
    private String major;
    private int generation;
    private String part;
    private String position;

    public StaffUpdateRequest() {}

    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getPosition() { return position; }

    public void setMajor(String major) { this.major = major; }
    public void setGeneration(int generation) { this.generation = generation; }
    public void setPart(String part) { this.part = part; }
    public void setPosition(String position) { this.position = position; }
}
