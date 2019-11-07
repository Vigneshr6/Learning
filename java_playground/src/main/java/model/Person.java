package model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Person {
	private long id;
	private String name;
	private int age;
	private Occupation occupation;
	private Gender gender;
	private LocalDate dob;

	public Person(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person(String name, int age, Occupation occupation, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.occupation = occupation;
		this.gender = gender;
	}

	public Person() {
		super();
	}

}
