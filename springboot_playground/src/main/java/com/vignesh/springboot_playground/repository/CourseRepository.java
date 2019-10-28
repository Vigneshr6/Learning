package com.vignesh.springboot_playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.springboot_playground.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
