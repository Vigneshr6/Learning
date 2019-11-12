package com.vignesh.java_playground.model;

public enum Gender {
	MALE("m"), FEMALE("f"), OTHER("o");
	private String shortName;

	Gender(String value) {
		this.shortName = value;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public static Gender getGender(String value) {
		for(Gender g :Gender.values()) {
			if(g.shortName.equals(value))
				return g;
		}
		throw new IllegalArgumentException("Gender '"+value+"' is not valid");
	}
}
