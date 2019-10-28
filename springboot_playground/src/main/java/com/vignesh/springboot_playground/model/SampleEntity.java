package com.vignesh.springboot_playground.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleEntity {
	private long id;
	private String name;
	private int age;

	public SampleEntity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
