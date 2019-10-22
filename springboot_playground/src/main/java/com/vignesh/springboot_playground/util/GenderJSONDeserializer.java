package com.vignesh.springboot_playground.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vignesh.springboot_playground.model.Gender;

public class GenderJSONDeserializer extends StdDeserializer<Gender> {

	protected GenderJSONDeserializer(Class<?> vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8004173390126861957L;

	@Override
	public Gender deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return Gender.of(p.getText());
	}

}
