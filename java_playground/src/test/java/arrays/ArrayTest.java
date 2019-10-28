package arrays;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.Person;

public class ArrayTest {
	private int[] ints;
	private int[] sortedInts;
	private Person[] persons;

	@Before
	public void init() {
		ints = new int[] { 9, 7, 8, 4, 3, 1, 6, 5, 2 };
		sortedInts = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		persons = new Person[] { new Person(1, "vignesh"), new Person(2, "divya"), new Person(3, "jaya kumar") };
	}

	@Test
	public void testArrayCopy() {
		int[] copied = Arrays.copyOf(ints, ints.length);
		System.out.println("Copied Array : " + Arrays.toString(copied));
		assertTrue(Arrays.equals(copied, ints));
	}

	@Test
	public void testArraySort() {
		Arrays.sort(ints);
		System.out.println("Sorted : " + Arrays.toString(ints));
		assertTrue(Arrays.equals(sortedInts, ints));
	}

	@Test
	public void testArraySortObjects() {
		Arrays.sort(persons, (p1,p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println("Sorted Persons : " + Arrays.toString(persons));
	}
}
