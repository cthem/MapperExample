package com.gnt.mapping.dto;

import java.util.List;

public class StudentDto extends MyDto {

	private int id;
	private String name;
	private SchoolDto schoolDto;
	private List<CourseDto> coursesDto;
	
	public StudentDto() {
		
	}

	public StudentDto(int id, String name, SchoolDto schoolDto, List<CourseDto> coursesDto) {
		super();
		this.id = id;
		this.name = name;
		this.schoolDto = schoolDto;
		this.coursesDto = coursesDto;
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

	public SchoolDto getSchoolDto() {
		return schoolDto;
	}

	public void setSchoolDto(SchoolDto schoolDto) {
		this.schoolDto = schoolDto;
	}

	public List<CourseDto> getCoursesDto() {
		return coursesDto;
	}

	public void setCoursesDto(List<CourseDto> coursesDto) {
		this.coursesDto = coursesDto;
	}
	
}
