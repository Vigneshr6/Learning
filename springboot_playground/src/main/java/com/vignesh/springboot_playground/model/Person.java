package com.vignesh.springboot_playground.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	@Min(value = 18, message = "Age should be atleast 18")
	private Integer age;
	@NotNull
	@JsonDeserialize(using = LocalDateJSONDeserializer.class)
	@JsonSerialize(using = LocalDateJSONSerializer.class)
	private LocalDate dob;
	@Transient
	@JsonIgnore
//	@JsonFormat(shape=Shape.STRING)
//	@Convert(converter = GenderAttributeConverter.class)
//	@JsonDeserialize(using = GenderJSONDeserializer.class)
//	@JsonSerialize(using = GenderJsonSerializer.class)
	private Gender gender;
	@Column(name = "gender", length = 1)
	@JsonProperty("gender")
	private String genderValue;

	@PostLoad
	public void fillTransient() {
		if (genderValue != null)
			this.gender = Gender.of(genderValue);
	}

	@PrePersist
	public void fillPersistent() {
		if (gender != null)
			this.genderValue = Gender.of(genderValue).getShortName();
	}
}
