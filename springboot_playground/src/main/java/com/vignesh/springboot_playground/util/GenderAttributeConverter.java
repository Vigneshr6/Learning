package com.vignesh.springboot_playground.util;

import javax.persistence.AttributeConverter;

import com.vignesh.springboot_playground.model.Gender;

public class GenderAttributeConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender attribute) {
		return attribute.getShortName();
	}

	@Override
	public Gender convertToEntityAttribute(String dbData) {
		return Gender.of(dbData);
	}

}
