package com.vignesh.java_playground.party;

import java.util.Arrays;

public class CombinationsTest {

	private int count = 0;
	
	public void printCombinations(char[] letters, int len) {
		printCombo(letters, new char[len], 0, letters.length, 0, len);
		System.out.println("count : " + count);
	}

	private void printCombo(char[] arr, char[] data, int start, int end, int dataIndex, int r) {
		if (dataIndex == r) {
			count++;
			System.out.println(Arrays.toString(data));
			return;
		} else {
			for (int i = start; i < end; i++) {
				data[dataIndex] = arr[i];
				printCombo(arr, data, i+1, end, dataIndex+1, r);
			}
		}
	}

	public static void main(String[] args) {
//		String input = "apple";
		String input = "12345";
		CombinationsTest app = new CombinationsTest();
		app.printCombinations(input.toCharArray(), 3);
	}
}
