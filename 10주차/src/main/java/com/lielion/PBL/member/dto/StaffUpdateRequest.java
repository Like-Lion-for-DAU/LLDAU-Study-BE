package com.lielion.PBL.member.dto;

public class StaffUpdateRequest {
	private String name;
	private String major;
	private int generation;
	private String part;
	private String position;

	public StaffUpdateRequest() {
	}

	public StaffUpdateRequest(String name, String major, int generation, String part, String position) {
		this.name = name;
		this.major = major;
		this.generation = generation;
		this.part = part;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
