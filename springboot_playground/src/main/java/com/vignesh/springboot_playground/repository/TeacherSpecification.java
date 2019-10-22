package com.vignesh.springboot_playground.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.vignesh.springboot_playground.model.Teacher;

public class TeacherSpecification {
	public static Specification<Teacher> hasBirthDay() {
		return (root, query, cb) -> {
			return cb.equal(root.get("dob"), LocalDate.now());
		};
	}
}
