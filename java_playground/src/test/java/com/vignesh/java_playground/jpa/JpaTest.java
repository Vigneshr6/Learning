package com.vignesh.java_playground.jpa;

import java.time.LocalDate;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vignesh.java_playground.model.Car;
import com.vignesh.java_playground.model.Gender;
import com.vignesh.java_playground.model.Occupation;
import com.vignesh.java_playground.model.Person;

public class JpaTest {
	private static EntityManagerFactory entityManagerFactory;
	private static final Logger log = LoggerFactory.getLogger(JpaTest.class);

	@BeforeClass
	public static void init() {
		log.debug("create entity manager");
		entityManagerFactory = Persistence.createEntityManagerFactory("default-unit", getJpaProperties());
	}

	private static Properties getJpaProperties() {
		Properties props = new Properties();
		props.put("connection.driver_class", "org.h2.Driver");
		props.put("hibernate.connection.url", "jdbc:h2:./db/jpa");
		props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "none");
		return props;
	}

	@Test
	@Ignore
	public void testPersist() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Person vignesh = new Person("vignesh", 24, Occupation.SALARIED_EMPLOYEE, Gender.MALE);
		vignesh.setDob(LocalDate.now());
		Person divya = new Person("divya", 23, Occupation.SALARIED_EMPLOYEE, Gender.FEMALE);
		entityManager.persist(vignesh);
		entityManager.persist(divya);
		Car audi = new Car("Audi", "Q3", "8055", vignesh);
		Car honda = new Car("Honda", "City", "1111", vignesh);

		Car audi2 = new Car("BMW", "X1", "A222", divya);
		Car honda2 = new Car("Suzuki", "Swift", "1010", divya);
		entityManager.persist(audi);
		entityManager.persist(honda);
		entityManager.persist(audi2);
		entityManager.persist(honda2);
		
		entityManager.getTransaction().commit(); //flush happens here.
		System.out.println("done");
	}
	
	@Test
	public void testFind() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Person person = entityManager.find(Person.class, 1l);
		System.out.println("person : " + person);
	}
	
}
