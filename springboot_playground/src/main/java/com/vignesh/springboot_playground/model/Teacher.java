package com.vignesh.springboot_playground.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Teacher extends Person {
	@JsonProperty
	private int exp;
	@OneToMany(mappedBy="mentor",cascade= {CascadeType.PERSIST})
	@JsonProperty
	@JsonIgnoreProperties("mentor")
	private List<Student> students;
	@Override
	public String toString() {
		return "Teacher [exp=" + exp + ", students=" + students + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + ", getDob()=" + getDob() + ", getGender()=" + getGender()
				+ ", getGenderValue()=" + getGenderValue() + "]";
	}
	
	
}
