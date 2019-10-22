package com.vignesh.springboot_playground.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vignesh.springboot_playground.model.Student;

@Repository
public class StudentFilterRepositoryImpl implements StudentFilterRepository {

	@Autowired
	private EntityManager em;

	@Override
	public List<Student> getStudentsWithCriteria(Student filter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
		Root<Student> student = query.from(Student.class);
		List<Predicate> predicates = new ArrayList<>();

		if (filter.getName() != null)
			predicates.add(cb.equal(student.get("name"), filter.getName()));
		if (filter.getAge() != null)
			predicates.add(cb.equal(student.get("age"), filter.getAge()));
		if (filter.getGender() != null)
			predicates.add(cb.equal(student.get("gender"), filter.getGender().getShortName()));
		if (!predicates.isEmpty())
			query.where(predicates.toArray(new Predicate[predicates.size()]));
		return em.createQuery(query).getResultList();
	}

}
