package com.vignesh.springboot_playground.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Student extends Person {
	@JsonProperty
	private Float cgpa;
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH})
	@JsonProperty
	private Laptop laptop;
	@ManyToOne
	@JsonProperty
	@JsonIgnoreProperties(value="students")
	private Teacher mentor;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="student_course",joinColumns=@JoinColumn(name="student_id"),inverseJoinColumns=@JoinColumn(name="course_id"))
	@JsonProperty
	@JsonIgnoreProperties("students")
	private List<Course> courses;
	@Override
	public String toString() {
		return "Student [cgpa=" + cgpa + ", laptop=" + laptop + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + ", getDob()=" + getDob() + ", getGender()=" + getGender()
				+ ", getGenderValue()=" + getGenderValue()+ "]";
	}
	
}
