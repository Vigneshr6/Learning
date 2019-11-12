package com.vignesh.java_playground.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vignesh.java_playground.model.Gender;
import com.vignesh.java_playground.model.Occupation;
import com.vignesh.java_playground.model.Person;

public class CollectionUtil {
	public static List<Person> getPersonList() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("vignesh", 24, Occupation.SALARIED_EMPLOYEE, Gender.MALE));
		personList.add(new Person("vignesh", null, Occupation.SALARIED_EMPLOYEE, Gender.MALE));
		personList.add(new Person("gayathri", 17, Occupation.STUDENT, Gender.FEMALE));
		personList.add(new Person("divya", 23, Occupation.SALARIED_EMPLOYEE, Gender.FEMALE));
		personList.add(new Person("varun", 15, Occupation.STUDENT, Gender.MALE));
		personList.add(new Person("jaya kumar", 33, Occupation.SELF_EMPLOYEED, Gender.MALE));
		personList.add(new Person("jaya kumar", 33, Occupation.SELF_EMPLOYEED, Gender.MALE));
		personList.add(new Person("rose", 30, Occupation.SALARIED_EMPLOYEE, Gender.OTHER));
		return personList;
	}

	public static Collection<Person> getPersonCollection() {
		return getPersonList();
	}
}
