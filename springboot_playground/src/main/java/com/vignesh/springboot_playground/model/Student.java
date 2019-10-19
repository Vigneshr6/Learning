package com.vignesh.springboot_playground.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	private Float cgpa;
}
