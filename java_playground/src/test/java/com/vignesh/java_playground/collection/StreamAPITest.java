package com.vignesh.java_playground.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Spliterator;

import org.junit.Test;

import com.vignesh.java_playground.model.Gender;
import com.vignesh.java_playground.model.Occupation;
import com.vignesh.java_playground.model.Person;

public class StreamAPITest {
	private static Collection<Person> personCollection;
	static {
		personCollection = new ArrayList<Person>();
		personCollection.add(new Person("vignesh", 24, Occupation.SALARIED_EMPLOYEE, Gender.MALE));
		personCollection.add(new Person("vignesh", 24, Occupation.SALARIED_EMPLOYEE, Gender.MALE));
		personCollection.add(new Person("gayathri", 17, Occupation.STUDENT, Gender.FEMALE));
		personCollection.add(new Person("divya", 23, Occupation.SALARIED_EMPLOYEE, Gender.FEMALE));
		personCollection.add(new Person("varun", 15, Occupation.STUDENT, Gender.MALE));
		personCollection.add(new Person("jaya kumar", 33, Occupation.SELF_EMPLOYEED, Gender.MALE));
		personCollection.add(new Person("jaya kumar", 33, Occupation.SELF_EMPLOYEED, Gender.MALE));
		personCollection.add(new Person("rose", 30, Occupation.SALARIED_EMPLOYEE, Gender.OTHER));
	}

	@Test
	public void testDistinct() {
		long count = personCollection.stream().distinct().count();
		System.out.println("count : " + count);
	}

	@Test
	public void test1() {
		Spliterator<Person> personSpliterator = personCollection.stream().distinct().spliterator();
		System.out.println("personSpliterator size: " + personSpliterator.estimateSize());
		Spliterator<Person> trySplit = personSpliterator.trySplit();
		System.out.println("trySplit size: " + trySplit.estimateSize());
		System.out.println("personSpliterator size: " + personSpliterator.estimateSize());
	}

	@Test
	public void testLimit() {
		System.out.println("Top 3 older persons");
		personCollection.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge()).limit(3).forEach(System.out::println);
	}

	@Test
	public void testCount() {
		long count = personCollection.stream().count();
		System.out.println("count : " + count);
	}

	@Test
	public void testMinMax() {
		System.out.println("Oldest person");
		Optional<Person> max = personCollection.stream().max((p1, p2) -> p1.getAge() - p2.getAge());
		if (max.isPresent()) {
			System.out.println("max : " + max.get());
		} else {
			System.out.println("Could not find");
		}
	}

	@Test
	public void testSkip() {
		long count = personCollection.stream().skip(2).count();
		System.out.println("count : " + count);
	}

	@Test
	public void testReduce() {
		// reduce output to single element
		Person emptyPerson = new Person();
		Person reduceResult = personCollection.stream().reduce(emptyPerson, (partialResult, p) -> {
			partialResult.setAge(partialResult.getAge() + p.getAge());
			return partialResult;
		});
		System.out.println("result : " + reduceResult);
	}
	
	@Test
	public void testSumAverage() {
		int sum = personCollection.stream().mapToInt(p -> p.getAge()).sum();
		System.out.println("sum : " + sum);
	}
	
}
