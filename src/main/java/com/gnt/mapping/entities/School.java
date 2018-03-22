package com.gnt.mapping.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the schools database table.
 * 
 */
@Entity
@Table(name="schools")
@NamedQuery(name="School.findAll", query="SELECT s FROM School s")
public class School extends MyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String name;

	//bi-directional one-to-one association to Student
	@OneToOne(mappedBy="school")
	private Student student;

	public School() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}