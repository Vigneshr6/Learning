package com.vignesh.springboot_playground.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.springboot_playground.model.Course;
import com.vignesh.springboot_playground.service.CourseService;

@RestController
@RequestMapping(value="/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getAll() {
		return courseService.getAll();
	}
}
