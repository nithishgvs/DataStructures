package org.nithish.arrays;

import java.util.Arrays;

public class PairsWithSum {

	/**
	 * Pair of Numbers with given Sum
	 * @param array
	 * @param Sum
	 */
	public static void PairsWithSumEqual(int[] array, int Sum) {
		Arrays.sort(array);
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			if (array[low] + array[high] > Sum) {
				high--;
			} else if (array[low] + array[high] < Sum) {
				low++;
			} else {
				System.out.println("Pair Found: " + array[low] + "," + array[high]);
				return;
			}

		}

	}

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 5, 4, 3, 1, 2, 6 };
		PairsWithSumEqual(array, 15);

	}

}
