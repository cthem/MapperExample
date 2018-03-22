package com.gnt.mapping.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the students database table.
 * 
 */
@Entity
@Table(name="students")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student extends MyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	@OneToOne
	@Column(name="school_id")
	private School school;
	
	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="student")
	private List<Course> courses;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCourse(Course course) {
		getCourses().add(course);
		course.setStudent(this);

		return course;
	}

	public Course removeCourse(Course course) {
		getCourses().remove(course);
		course.setStudent(null);

		return course;
	}

}