package com.vignesh.java_playground.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Person {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Occupation occupation;
	@Transient
	private Gender gender;
	@Column(name="gender")
	private String genderValue;
	private LocalDate dob;

	public Person(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person(String name, Integer age, Occupation occupation, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.occupation = occupation;
		this.gender = gender;
	}

	public Person() {
		super();
	}
	
	@PostLoad
	void loadTransient() {
		gender = Gender.getGender(genderValue);
	}
	
	@PrePersist
	void generatePersistent() {
		genderValue = gender.getShortName();
	}

}
