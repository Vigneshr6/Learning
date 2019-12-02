package com.vignesh.java_playground.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@OneToMany(mappedBy = "owner",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@BatchSize(size = 10)
	private List<Car> cars;

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

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", occupation=" + occupation + ", gender="
				+ gender + ", genderValue=" + genderValue + ", dob=" + dob + ", cars=" + cars + "]";
	}
	
	
}
