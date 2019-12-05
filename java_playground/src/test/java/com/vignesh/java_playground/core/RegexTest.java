package com.vignesh.java_playground.core;

import static org.junit.Assert.fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author gbs05074
 *
 */
public class RegexTest {

	@Test
	public void testCapturingGroup() {
		String regex = "(\\w)+(\\1)";
		String input = getInput();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()) {
			String group = matcher.group();
			System.out.println("group : " + group);
		}
		System.out.println("done");
	}
	
	/*
	 * prints wors with repeated letters
	*/		
	@Test
	public void testRepeatedLetters() {
		String regex = "\\b\\w*(\\w)\\1+\\w*\\b";
		String input = getInput();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()) {
			String group = matcher.group();
			System.out.println("group : " + group);
		}
		System.out.println("done");
	}
	
	/*
	 * prints words which contains a same letter more than once
	 */
	@Test
	public void testWordWithSameLetter() {
		String regex = "\\b\\w*(\\w)\\w*\\1\\w*\\b";
//		String regex = "[^\\s]*(\\w)\\w*\\1[^\\s]*";
		String input = getInput();
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while(matcher.find()) {
			count++;
			String group = matcher.group();
			System.out.println("group : " + group);
		}
		System.out.println("matches : "+count);
	}
	
	/*
	 * checks atleast 1 uppercase
	 * checks atleats 1 lowercase
	 * checks atleast 1 number
	 * checks atleast 1 of the following special char @,#,$,*
	 */
	@Test
	public void testPassword() {
		String input = "Mypassword1$";
		if(!Pattern.matches(".*[A-Z]+.*", input)) {
			fail("Password should contain atleast 1 uppercase letter");
		}
		if(!Pattern.matches(".*[a-z]+.*", input)) {
			fail("Password should contain atleast 1 lowercase letter");
		}
		if(!Pattern.matches(".*\\d+.*", input)) {
			fail("Password should contain atleast 1 numeric value");
		}
		if(!Pattern.matches(".*[@#$*]+.*", input)) {
			fail("Password should contain atleast 1 special character");
		}
		System.out.println(input+" is valid");
	}
	
	/*
	 * (?=) is lookahead positive
	 *  won't capture
	 *  text will be selected only if it passes the (?=) condition
	 */
	@Test
	public void testLookAheadPositive() {
		String regex = "(?=[a-zA-Z0-9@#$*]{8,30}$)(?=.*[a-z]+.*)(?=.*[A-Z]+.*)(?=.*[\\d]+.*)(?=.*[@#$*]+.*)(.+)";
//		String regex = "(?=[a-zA-Z0-9@#$*]{8,30}$)(?=.*[a-z]+.*).+";
		String input = "Mypassword#1";
		boolean matches = Pattern.matches(regex, input);
		System.out.println("matches : " + matches);
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while(matcher.find()) {
			count++;
			String group = matcher.group();
			System.out.println("group : " + group);
		}
		System.out.println("matches : "+count);
	}
	
	private String getInput() {
		return "Sunset is the time of day when our sky meets the outer space solar winds. There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught in a whirlwind. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that must still be done. There is a coolness, a calmness, when the sun does set.";
	}
}
