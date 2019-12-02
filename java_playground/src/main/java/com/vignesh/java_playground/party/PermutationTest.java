package com.vignesh.java_playground.party;

public class PermutationTest {

	private int count = 0;
	
	void printPermutations(String input) {
		printPermutations(input,"");
		System.out.println("Total : "+count);
	}

	private void printPermutations(String input,String prefix) {
		if (input.length() == 0) {
			count++;
			System.out.println(prefix);
		} else {
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				String remaining = input.substring(0 , i) + input.substring(i +1);
				printPermutations(remaining, prefix+ch);
			}
		}
	}

	public static void main(String[] args) {
		String input = "apple";
		PermutationTest app = new PermutationTest();
		app.printPermutations(input);
	}
}
