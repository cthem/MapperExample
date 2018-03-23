package com.gnt.mapping.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gnt.mapping.dto.SchoolDto;
import com.gnt.mapping.dto.StudentDto;
import com.gnt.mapping.entities.School;
import com.gnt.mapping.entities.Student;

@Mapper(componentModel = "sdi")
public interface SchoolMapper {
	StudentDto convertStudentToStudentDto(Student student);
	Student convertStudentDtoToStudent(StudentDto studentDto);
	@Mapping(target="studentDto",source="student")
	SchoolDto convertSchoolToSchoolDto(School school);
	@Mapping(target="student",source="studentDto")
	School convertSchoolDtoToSchool(SchoolDto schoolDto);
}
