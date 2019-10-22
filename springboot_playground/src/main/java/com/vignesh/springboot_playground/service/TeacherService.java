package com.vignesh.springboot_playground.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.springboot_playground.model.Teacher;
import com.vignesh.springboot_playground.repository.TeacherRepository;
import com.vignesh.springboot_playground.repository.TeacherSpecification;

@Service("teacherService")
@Transactional
public class TeacherService extends TeacherSpecification {
	@Autowired
	private TeacherRepository repository;

	public List<Teacher> getAll() {
		return repository.findAll();
	}

	public Teacher addTeacher(Teacher p) {
		return repository.save(p);
	}

	public List<Teacher> getTeacherWithTodayBirthday() {
		return repository.findAll(hasBirthDay());
	}
}
