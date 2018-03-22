package com.gnt.mapping.dto;

public class SchoolDto extends MyDto {

	private int id;
	private String address;
	private String name;
	private StudentDto studentDto;
	
	public SchoolDto() {
		
	}

	public SchoolDto(int id, String address, String name, StudentDto studentDto) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.studentDto = studentDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}
	
}
