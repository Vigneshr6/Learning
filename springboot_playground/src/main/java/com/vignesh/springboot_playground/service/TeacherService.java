package com.vignesh.springboot_playground.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.springboot_playground.model.Teacher;
import com.vignesh.springboot_playground.repository.TeacherRepository;
import com.vignesh.springboot_playground.repository.TeacherSpecification;

@Service("teacherService")
@Transactional
public class TeacherService extends TeacherSpecification {
	
	private static final Logger log = LoggerFactory.getLogger(TeacherService.class);

	
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
	
	public void deleteTeacher(long id) {
		repository.deleteById(id);
	}
	
	public Teacher updateTeacher(Teacher t,long id) {
		log.debug("updated record : "+t);
		Optional<Teacher> findById = repository.findById(id);
		if(!findById.isPresent())
			throw new IllegalArgumentException("id '"+id+"' not found");
		t.setId(id);
		repository.save(t);
		return t;
	}
}
