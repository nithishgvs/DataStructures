package org.nithish.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysPractice {

	/**
	 * Find the number which occurs odd number of times
	 * 
	 * @param array
	 */
	public static void oddTimesOccurence(int[] array) {

		HashMap<Integer, Integer> mapIntegers = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			if (mapIntegers.containsKey(array[i])) {
				int newValue = mapIntegers.get(array[i]) + 1;
				mapIntegers.put(array[i], newValue);
			} else {
				mapIntegers.put(array[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : mapIntegers.entrySet()) {
			if (entry.getValue() % 2 != 0)
				System.out.println("Odd occured Number is : " + entry.getKey());
		}
	}

	//
	/**
	 * Find the missing number in the duplicate array
	 * 
	 * @param array1
	 * @param array2
	 *            Given two integer arrays where second array is duplicate of
	 *            first array with just 1 element missing. Find the element.
	 *            Example:
	 * 
	 *            Input: Array1 - 9 7 8 5 4 6 2 3 1 Array2 - 2 4 3 9 1 8 5 6
	 * 
	 *            Output: 7
	 */
	public static void missingNumberInDuplicateArray(int[] array1, int[] array2) {
		HashMap<Integer, Integer> mapIntegers = new HashMap<>();

		for (int i = 0; i < array1.length; i++) {
			mapIntegers.put(array1[i], 1);
		}
		for (int i = 0; i < array2.length; i++) {
			if (mapIntegers.containsKey(array2[i])) {
				int newValue = mapIntegers.get(array2[i]) + 1;
				mapIntegers.put(array2[i], newValue);
			} else {
				mapIntegers.put(array2[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : mapIntegers.entrySet()) {
			if (entry.getValue() % 2 != 0)
				System.out.println("Odd occured Number is : " + entry.getKey());
		}

	}

	public static void printingMatrixDiagnolly(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int col;
		int row;
		for (row = 0; row < rowLen; row++) {
			int temprow = row;
			for (col = 0; col < colLen && row >= 0; col++) {
				System.out.print(matrix[row][col]);
				row--;
				System.out.print(" ");
			}
			row = temprow;
			System.out.println(" ");
		}

		for (col = 1; col < colLen; col++) {
			int tempcol = col;
			for (row = rowLen - 1; row >= 0 && col < colLen;) {
				System.out.print(matrix[row][col]);
				row--;
				System.out.print(" ");
				col++;
			}
			col = tempcol;
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 9, 7, 8, 5, 4, 6, 2, 3, 1 };
		int[] array2 = { 2, 4, 3, 9, 1, 8, 5, 6 };

		int row = 4, col = 5;
		int k = 1;
		int matrix[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = k++;
			}
		}

		System.out.println("Input Matrix");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		printingMatrixDiagnolly(matrix);
	}

}
