package org.nithish.arrays;

import java.util.Arrays;

public class MatrixPrograms {

	/**
	 * Inplace Sorting 1.Transpose of matrix 2.Reverse Columns
	 * 
	 * @param array
	 */
	public static void MatrixRotation(int[][] array) {
		// Transpose of a Matrix
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (i < j) {
					int temp = array[i][j];
					array[i][j] = array[j][i];
					array[j][i] = temp;
				}
			}
		}
		System.out.println("After Transpose");
		PrintArrayUtility(array);
		// Reverse Columns of the Transpose
		for (int i = 0; i < array.length; i++) {
			for (int j = array[0].length - 1, k = 0; j >= k; j--, k++) {
				System.out.println(i);
				if (k == j) {
					continue;
				}
				int temp = array[k][i];
				array[k][i] = array[j][i];
				array[j][i] = temp;
			}
		}
		System.out.println("After Reversing Columns ");
		PrintArrayUtility(array);

	}

	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		PrintArrayUtility(array);
		MatrixRotation(array);

	}

	private static void PrintArrayUtility(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
