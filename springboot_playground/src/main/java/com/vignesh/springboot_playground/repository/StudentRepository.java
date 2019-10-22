package com.vignesh.springboot_playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.springboot_playground.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>, StudentFilterRepository {

}
