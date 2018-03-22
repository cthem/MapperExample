package com.gnt.mapping.dto;

public class CourseDto extends MyDto {

	private int id;
	private String name;
	private String teacher;
	private StudentDto studentDto;
	
	public CourseDto() {
		
	}
	
	public CourseDto(int id, String name, String teacher, StudentDto studentDto) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.studentDto = studentDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}
	
}
