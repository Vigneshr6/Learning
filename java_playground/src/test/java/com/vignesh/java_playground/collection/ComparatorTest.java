package com.vignesh.java_playground.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.vignesh.java_playground.model.Person;
import com.vignesh.java_playground.util.CollectionUtil;

public class ComparatorTest {
	private List<Person> personList;

	@Before
	public void init() {
		personList = CollectionUtil.getPersonList();
	}

	@Test
	public void testComparing() {
		System.out.println("Before sort");
		personList.forEach(System.out::println);
		
		Collections.sort(personList, Comparator.comparing(Person::getName));
		
		System.out.println("After sort");
		personList.forEach(System.out::println);
	}
	
	@Test
	public void testReversed() {
		System.out.println("Before sort");
		personList.forEach(System.out::println);
		
		Collections.sort(personList, Comparator.comparing(Person::getName).reversed());
		
		System.out.println("After sort");
		personList.forEach(System.out::println);
	}
	
	@Test
	public void testNullsFirst() {
		System.out.println("Before sort");
		List<Integer> ages = personList.stream().map(p -> p.getAge()).collect(Collectors.toList());
		ages.forEach(System.out::println);
		
		ages.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
		
		System.out.println();
		System.out.println("After sort");
		ages.forEach(System.out::println);
	}
}
