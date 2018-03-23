package com.gnt.mapping.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;

import com.gnt.mapping.dto.CourseDto;
import com.gnt.mapping.dto.SchoolDto;
import com.gnt.mapping.dto.StudentDto;
import com.gnt.mapping.entities.Course;
import com.gnt.mapping.entities.School;
import com.gnt.mapping.entities.Student;

public class Test {
//	private static EntityDtoMapper mapper = Mappers.getMapper(EntityDtoMapper.class);
	private static StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
	private static SchoolMapper schoolMapper = Mappers.getMapper(SchoolMapper.class);
	private static CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);
	
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("George");
		student.setId(1);

		Course course1 = new Course();
		course1.setId(1);
		course1.setName("Maths");
		course1.setTeacher("Antoniou");
		course1.setStudent(student);

		Course course2 = new Course();
		course2.setId(2);
		course2.setName("Physics");
		course2.setTeacher("Priftis");
		course2.setStudent(student);

		List<Course> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		student.setCourses(courses);
		
		School school = new School();
		school.setName("LFH");
		school.setAddress("Ag. Parask");
		school.setStudent(student);
		student.setSchool(school);
		
		CourseDto courseDto1 = courseMapper.convertCourseToCourseDto(course1);
		CourseDto courseDto2 = courseMapper.convertCourseToCourseDto(course2);
		System.out.println(courseDto1.getName() + " " + course1.getName());
		System.out.println(courseDto2.getName() + " " + course2.getName());
		
		StudentDto studentDto = studentMapper.convertStudentToStudentDto(student);
		System.out.println(studentDto.getName() + " " + student.getName());
		
		SchoolDto schoolDto = schoolMapper.convertSchoolToSchoolDto(school);
		System.out.println(schoolDto.getStudentDto().getName());
		System.out.println(studentDto.getCoursesDto().get(0).getName() + " " + student.getCourses().get(0).getName());
		System.out.println(studentDto.getSchoolDto().getName() + " " + student.getSchool().getName());
		
		School school2= schoolMapper.convertSchoolDtoToSchool(schoolDto);
		System.out.println(school2.getStudent().getName() + " " + schoolDto.getStudentDto().getName());
	}
}
