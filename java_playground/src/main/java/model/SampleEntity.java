package model;

import lombok.Data;

@Data
public class SampleEntity {
	private long id;
	private String name;
	private int age;

	public SampleEntity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public SampleEntity() {
		super();
	}

}
