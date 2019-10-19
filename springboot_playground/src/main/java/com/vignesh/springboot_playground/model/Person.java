package com.vignesh.springboot_playground.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vignesh.springboot_playground.util.LocalDateJSONDeserializer;
import com.vignesh.springboot_playground.util.LocalDateJSONSerializer;

import lombok.Data;

@MappedSuperclass
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Min(value = 18,message="Age should be atleast 18")
	private int age;
	@NotNull
	@JsonDeserialize(using = LocalDateJSONDeserializer.class)
	@JsonSerialize(using = LocalDateJSONSerializer.class)
	private LocalDate dob;
}
