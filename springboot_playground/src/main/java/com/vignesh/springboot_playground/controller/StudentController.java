package com.vignesh.springboot_playground.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.springboot_playground.model.Student;
import com.vignesh.springboot_playground.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	
	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<Student> getEmployees(Student student) {
		List<Student> all = studentService.getStudents(student);
		return all;
	}
	
	@GetMapping(value="/{id}")
	public Student getStudentById(@PathVariable(required=true) long id){
		Student studentById = studentService.getStudentById(id);
		log.debug("found : "+studentById);
		return studentById;
	}
	
	@GetMapping(value="/firstclass")
	public List<Student> getFirstClassStudents(){
		return studentService.firstClassStudents();
	}

	@PostMapping
	public ResponseEntity<Student> createPerson(@Valid @RequestBody Student s) {
		Student created = studentService.addStudent(s);
		return new ResponseEntity<Student>(created, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}")
	public Student updateStudent(@Valid @RequestBody Student s,@PathVariable(required=true,value="id") long id){
		log.debug("to be updated : "+s);
		Student updateStudent = studentService.updateStudent(s, id);
		return updateStudent;
	}
}
