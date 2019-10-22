package com.vignesh.springboot_playground.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.springboot_playground.model.Student;
import com.vignesh.springboot_playground.repository.StudentRepository;

@Transactional
@Service("studentService")
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> getAll() {
		return repository.findAll();
	}

	public Student addStudent(Student p) {
		return repository.save(p);
	}
	
	public List<Student> getStudents(Student st) {
		return repository.getStudentsWithCriteria(st);
	}
}
