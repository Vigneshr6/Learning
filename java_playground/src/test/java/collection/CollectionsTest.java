package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CollectionsTest {

	private List<String> list1, list2;

	@Before
	public void init() {
		list1 = new ArrayList<>(Arrays.asList("one", "two", "three", "one","four"));
		list2 = new ArrayList<>();
		list2.add(list1.get(0));
	}

	@Test
	public void testUnmodifiableList() {
//		Collections.unmodifiableMap(arg0)
		List<String> unmodifiableList = Collections.unmodifiableList(list1);
		try {
			unmodifiableList.add("four");
		} catch (UnsupportedOperationException e) {
			System.out.println("ex : " + e);
		}
	}

	@Test
	public void testSwap() {
		System.out.println("Before swap");
		list1.forEach(System.out::println);

		Collections.swap(list1, 0, 1);

		System.out.println("After swap");
		list1.forEach(System.out::println);
	}

	@Test
	public void testEmptyCollection() {
		List emptyList = Collections.EMPTY_LIST;
		emptyList.add("one");
	}

	@Test
	public void testDisjoint() {
		// check if no common elemnts in the list
		boolean disjoint = Collections.disjoint(list1, list2);
		System.out.println("disjoint : " + disjoint);
	}

	@Test
	public void testFrequency() {
		// calculates the no of occurences of an element
		int frequency = Collections.frequency(list1, "one");
		System.out.println("frequency : " + frequency);
	}

	@Test
	public void testNCopies() {
		List<String> nCopies = Collections.nCopies(5, "two");
		nCopies.forEach(System.out::println);
	}

	@Test
	public void testSingleton() {
		//create an immutable list with one element
		List<String> singletonList = Collections.singletonList("one");
		singletonList.forEach(System.out::println);
	}
	
	@Test
	public void testFill() {
		//replaces all the elements
		Collections.fill(list2, "three");
		list2.forEach(System.out::println);
	}
	
	@Test
	public void testReverse() {
		System.out.println("Before reverse");
		list1.forEach(System.out::println);
		
		Collections.reverse(list1);
		
		System.out.println("After reverse");
		list1.forEach(System.out::println);
	}
	
	@Test
	public void testRotate() {
		//rotates last n elements to top
		System.out.println("Before rotate");
		list1.forEach(System.out::println);
		
		Collections.rotate(list1, 2);
		
		System.out.println("After rotate");
		list1.forEach(System.out::println);
	}

}
