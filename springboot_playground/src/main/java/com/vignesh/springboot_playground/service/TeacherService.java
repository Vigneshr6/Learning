package com.vignesh.springboot_playground.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.springboot_playground.model.Teacher;
import com.vignesh.springboot_playground.repository.TeacherRepository;

@Service("teacherService")
public class TeacherService {
	@Autowired
	private TeacherRepository repository;

	public List<Teacher> getAll() {
		return repository.findAll();
	}

	public Teacher addTeacher(Teacher p) {
		return repository.save(p);
	}
}
