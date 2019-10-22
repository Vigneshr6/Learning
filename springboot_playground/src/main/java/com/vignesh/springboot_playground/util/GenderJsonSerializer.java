package com.vignesh.springboot_playground.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.vignesh.springboot_playground.model.Gender;

public class GenderJsonSerializer extends StdSerializer<Gender> {

	protected GenderJsonSerializer(Class<Gender> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5051621475719896020L;

	@Override
	public void serialize(Gender value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getShortName());
	}

}
