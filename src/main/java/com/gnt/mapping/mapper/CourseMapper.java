package com.gnt.mapping.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gnt.mapping.dto.CourseDto;
import com.gnt.mapping.dto.StudentDto;
import com.gnt.mapping.entities.Course;
import com.gnt.mapping.entities.Student;

@Mapper(componentModel = "cdi")
public interface CourseMapper {
	StudentDto convertStudentToStudentDto(Student student);
	Student convertStudentDtoToStudent(StudentDto studentDto);
	@Mapping(target="studentDto",source="student")
	CourseDto convertCourseToCourseDto(Course course);
	@Mapping(target="student",source="studentDto")
	Course convertCourseDtoToCourse(CourseDto courseDto);
}
