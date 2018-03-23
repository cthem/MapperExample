package com.gnt.mapping.test.junit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import com.gnt.mapping.dto.CourseDto;
import com.gnt.mapping.dto.SchoolDto;
import com.gnt.mapping.dto.StudentDto;
import com.gnt.mapping.entities.Course;
import com.gnt.mapping.entities.School;
import com.gnt.mapping.entities.Student;
import com.gnt.mapping.mapper.CourseMapper;
import com.gnt.mapping.mapper.SchoolMapper;
import com.gnt.mapping.mapper.StudentMapper;

public class MapperTest {
//	private EntityDtoMapper mapper = Mappers.getMapper(EntityDtoMapper.class);
	private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
	private SchoolMapper schoolMapper = Mappers.getMapper(SchoolMapper.class);
	private CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);
	
	@Test
	public void test() {
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
		assertEquals(courseDto1.getName(), course1.getName());
		assertEquals(courseDto2.getName(), course2.getName());
		assertEquals(courseDto1.getStudentDto().getName(), course1.getStudent().getName());
		assertEquals(courseDto2.getStudentDto().getName(), course2.getStudent().getName());

		SchoolDto schoolDto = schoolMapper.convertSchoolToSchoolDto(school);
		assertEquals(schoolDto.getName(), school.getName());
		assertEquals(schoolDto.getStudentDto().getName(), school.getStudent().getName());

		StudentDto studentDto = studentMapper.convertStudentToStudentDto(student);
		assertEquals(studentDto.getName(), student.getName());
		assertEquals(studentDto.getSchoolDto().getName(), student.getSchool().getName());
		assertEquals(studentDto.getCoursesDto().get(0).getName(), student.getCourses().get(0).getName());
	}

}
