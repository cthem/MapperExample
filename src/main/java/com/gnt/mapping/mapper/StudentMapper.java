package com.gnt.mapping.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.gnt.mapping.dto.CourseDto;
import com.gnt.mapping.dto.SchoolDto;
import com.gnt.mapping.dto.StudentDto;
import com.gnt.mapping.entities.Course;
import com.gnt.mapping.entities.School;
import com.gnt.mapping.entities.Student;

@Mapper(componentModel = "sdi")
public interface StudentMapper {
	@Mappings({ 
		@Mapping(target = "schoolDto", source = "school"),
		@Mapping(target = "coursesDto", source = "courses") 
	})
	StudentDto convertStudentToStudentDto(Student student);

	@Mappings({ 
		@Mapping(target = "school", source = "schoolDto"),
		@Mapping(target = "courses", source = "coursesDto") 
	})
	Student convertStudentDtoToStudent(StudentDto studentDto);
	
	SchoolDto convertSchoolToSchoolDto(School school);
	School convertSchoolDtoToSchool(SchoolDto schoolDto);
	
	CourseDto convertCourseToCourseDto(Course course);
	Course convertCourseDtoToCourse(CourseDto courseDto);
}
