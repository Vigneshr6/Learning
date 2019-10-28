package com.vignesh.springboot_playground.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.springboot_playground.model.Course;
import com.vignesh.springboot_playground.repository.CourseRepository;

@Service("courseService")
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAll() {
		return courseRepository.findAll();
	}
}
