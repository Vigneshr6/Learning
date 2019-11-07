package java8;

import java.util.Optional;

import org.junit.Test;

public class OptionalAPITest {

	private static Optional<String> getOptionalString() {
		return Optional.ofNullable(null);
	}
	
	private static String getDefaultString() {
		return "defaultValue";
	}
	
	@Test
	public void elseTest() {
		String name = getOptionalString().orElse("nothing");
		System.out.println("name : " + name);
	}
	
	@Test
	public void elseGetTest() {
		String name = getOptionalString().orElseGet(OptionalAPITest::getDefaultString);
		System.out.println("name : " + name);
	}
}
