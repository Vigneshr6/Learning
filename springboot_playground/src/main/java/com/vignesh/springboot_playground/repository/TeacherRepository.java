package com.vignesh.springboot_playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vignesh.springboot_playground.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>,JpaSpecificationExecutor<Teacher>{
}
