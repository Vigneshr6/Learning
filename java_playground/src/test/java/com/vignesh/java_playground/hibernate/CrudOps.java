package com.vignesh.java_playground.hibernate;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.persistence.NamedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.vignesh.java_playground.model.Car;
import com.vignesh.java_playground.model.Gender;
import com.vignesh.java_playground.model.LocalDateConverter;
import com.vignesh.java_playground.model.Occupation;
import com.vignesh.java_playground.model.Person;

@NamedQuery(name = "getPersonWithDOB",query = "select p from person where p.dob = sysdate()")
public class CrudOps {
	private static Properties H2;
	private static Properties ORACLE;
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void init() {
		H2 = getH2HibernateProperties();
		ORACLE = getOracleDataSourceProperties();
		sessionFactory = buildSessionFactory(H2);
	}
	
	private static Properties getH2HibernateProperties() {
		Properties props = new Properties();
		props.put("connection.driver_class", "org.h2.Driver");
		props.put("hibernate.connection.url", "jdbc:h2:./db/hibernate");
		props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");

		return props;
	}
	
	private static Properties getOracleDataSourceProperties() {
		Properties props = new Properties();
		props.put("connection.driver_class", "oracle.jdbc.OracleDriver");
		props.put("hibernate.connection.url", "jdbc:oracle:thin:@teorabe");
		props.put("hibernate.connection.username", "svil_team24");
		props.put("hibernate.connection.password", "Sep.2016");
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		
		return props;
	}

	private static SessionFactory buildSessionFactory(Properties props) {
		return new AnnotationConfiguration()
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(LocalDateConverter.class)
				.addProperties(props)
				.buildSessionFactory();
	}

//	@Ignore
	@Test
	public void populateData() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person vignesh = new Person("vignesh", 24, Occupation.SALARIED_EMPLOYEE, Gender.MALE);
		vignesh.setDob(LocalDate.now());
		Person divya = new Person("divya", 23, Occupation.SALARIED_EMPLOYEE, Gender.FEMALE);
		session.save(vignesh);
		session.save(divya);
		Car audi = new Car("Audi", "Q3", "8055", vignesh);
		Car honda = new Car("Honda", "City", "1111", vignesh);
		
		Car audi2 = new Car("BMW", "X1", "A222", divya);
		Car honda2 = new Car("Suzuki", "Swift", "1010", divya);
		session.save(audi);
		session.save(honda);
		session.save(audi2);
		session.save(honda2);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void showRecords() {
		Session session = sessionFactory.openSession();
		List<Person> cars = session.createCriteria(Person.class).list();
		System.out.println("\t\tPersons");
		cars.forEach(System.out::println);
		session.close();
	}
	
	@Test
	public void testCurrentSeesion() {
		Session session = sessionFactory.getCurrentSession();
	}
	
	@Test
	public void testUpdate() {
		Session session = sessionFactory.openSession();
		
		Person vignesh = new Person("vignesh", 25, Occupation.SALARIED_EMPLOYEE, Gender.MALE);
		vignesh.setId(1l);
		session.beginTransaction();
		
		session.update(vignesh);
		
		vignesh.setAge(26);//latest modification applies
		
		session.update(vignesh);
		
		session.getTransaction().commit();
	}
		
	@Test
	public void queryRecords() {
		Session session = sessionFactory.openSession();
	}
}
