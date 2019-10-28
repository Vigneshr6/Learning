package com.vignesh.springboot_playground.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.springboot_playground.model.Student;
import com.vignesh.springboot_playground.repository.StudentRepository;
import com.vignesh.springboot_playground.repository.StudentSpecification;

@Transactional
@Service("studentService")
public class StudentService extends StudentSpecification{

	@Autowired
	private StudentRepository repository;

	public List<Student> getAll() {
		return repository.findAll();
	}
	
	public Student getStudentById(long id) {
		return repository.findById(id).orElseThrow(() -> {
			throw new IllegalArgumentException("id '"+id+"' not found");
		});	
	}

	public Student addStudent(Student p) {
		return repository.save(p);
	}
	
	public List<Student> getStudents(Student st) {
		return repository.getStudentsWithCriteria(st);
	}
	
	public void deleteStudent(long id) {
		repository.deleteById(id);
	}
	
	public Student updateStudent(Student s,long id) throws IllegalArgumentException{
		Optional<Student> existing = repository.findById(id);
		if(!existing.isPresent())
			throw new IllegalArgumentException("student id '"+id+"' does not exist");
		s.setId(id);
		return repository.save(s);
	}
	
	public List<Student> firstClassStudents(){
		return repository.findAll(gotFirstClass());
	}
}
