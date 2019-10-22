package com.vignesh.springboot_playground.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.springboot_playground.model.Student;
import com.vignesh.springboot_playground.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<Student> getEmployees(Student student) {
		List<Student> all = studentService.getStudents(student);
		return all;
	}

	@PostMapping
	public ResponseEntity<Student> createPerson(@Valid @RequestBody Student s) {
		Student created = studentService.addStudent(s);
		return new ResponseEntity<Student>(created, HttpStatus.CREATED);
	}
}
