package com.vignesh.springboot_playground.repository;

import org.springframework.data.jpa.domain.Specification;

import com.vignesh.springboot_playground.model.Student;

public class StudentSpecification {
	public Specification<Student> gotFirstClass() {
		return (root,query,cb) -> {
			return cb.greaterThanOrEqualTo(root.get("cgpa"), 7.0d);
		};
	}
}
