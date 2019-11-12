package com.vignesh.java_playground.sorting;

import java.util.Arrays;

public class BubbleSort {

	private void sort(int[] array) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				int j = i + 1;
				if (array[i] > array[j]) {
					sorted = false;
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] input = new int[] { 4, 3, 5, 2, 7, 6 };
		BubbleSort bubble = new BubbleSort();
		System.out.println("before sort");
		System.out.println(Arrays.toString(input));
		bubble.sort(input);
		System.out.println("after sort");
		System.out.println(Arrays.toString(input));
	}
}
