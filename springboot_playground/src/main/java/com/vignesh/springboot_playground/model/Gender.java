package com.vignesh.springboot_playground.model;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
	MALE("m"), FEMALE("f"), OTHER("o");

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	@JsonCreator
	public static Gender of(String value) {
		System.out.println("creator called");
		return Stream.of(Gender.values()).filter(g -> g.getShortName().equals(value)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	@JsonValue
	public String getShortName() {
		return value;
	}
}
