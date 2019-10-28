package model;

import lombok.Data;

@Data
public class Person {
	private long id;
	private String name;

	public Person(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
