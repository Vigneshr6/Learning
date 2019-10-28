package com.vignesh.springboot_playground.model;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
	MALE("m"), FEMALE("f"), OTHER("o");

	
	private static final Logger log = LoggerFactory.getLogger(Gender.class);

	
	private String value;

	private Gender(String value) {
		this.value = value;
	}

	@JsonCreator
	public static Gender of(String value) {
		log.debug("creator called : "+value);
		return Stream.of(Gender.values()).filter(g -> g.getShortName().equals(value)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	@JsonValue
	public String getShortName() {
		return value;
	}
}
