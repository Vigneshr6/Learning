package com.vignesh.springboot_playground.repository;

import java.util.List;

import com.vignesh.springboot_playground.model.Student;

public interface StudentFilterRepository {
	public List<Student> getStudentsWithCriteria(Student student);
}
