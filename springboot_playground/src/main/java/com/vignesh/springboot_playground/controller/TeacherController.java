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

import com.vignesh.springboot_playground.model.Teacher;
import com.vignesh.springboot_playground.service.TeacherService;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@GetMapping
	public ResponseEntity<List<Teacher>> getAllEmployees() {
		List<Teacher> all = teacherService.getAll();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Teacher> createPerson(@Valid @RequestBody Teacher t) {
		Teacher created = teacherService.addTeacher(t);
		return new ResponseEntity<Teacher>(created, HttpStatus.CREATED);
	}
}
