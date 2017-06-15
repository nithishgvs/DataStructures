package org.nithish.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.nithish.sorting.QuickSort;

public class ArrayPrograms {

	/**
	 * O(n2) Solution
	 * 
	 * @param array
	 * @param sum
	 */
	public static void hasArrayTwoCandidatesSolution1(int array[], int sum) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if ((array[i] + array[j]) == 10) {
					System.out.println("Sum Pairs Found: " + array[i] + "," + array[j]);
				}
			}
		}

	}

	/**
	 * O(nlogn) Solution
	 * 
	 * @param array
	 * @param sum
	 */
	public static void hasArrayTwoCandidatesSolution2(int array[], int sum) {
		QuickSort.quickSort(array, 0, array.length - 1);
		int l = 0;
		int r = array.length - 1;
		while (l < r) {
			if (array[l] + array[r] == sum) {
				System.out.println("Sum Pairs Found: " + array[l] + "," + array[r]);
				return;
			} else if (array[l] + array[r] > sum) {
				r--;
			} else if (array[l] + array[r] < sum) {
				l++;
			}
		}

	}

	/**
	 * O(n) Solution
	 * 
	 * @param A
	 * @param sum
	 */
	public static void hasArrayTwoCandidatesSolution3(int A[], int sum) {
		int size = 100;
		Boolean[] array = new Boolean[size];
		Arrays.fill(array, Boolean.FALSE);
		for (int i = 0; i < A.length - 1; i++) {
			int temp = sum - A[i];
			if (temp >= 0 && array[temp] == Boolean.TRUE) {
				System.out.println("Pair with given sum " + sum + " is (" + A[i] + ", " + temp + ")");
			}
			array[A[i]] = Boolean.TRUE;
		}
	}

	/**
	 * O(n) Majority Element: A majority element in an array A[] of size n is an
	 * element that appears more than n/2 times
	 * 
	 * @param A
	 */
	public static void majorityElement(int A[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				int val = map.get(A[i]) + 1;
				map.put(A[i], val);
			} else {
				map.put(A[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > A.length / 2) {
				System.out.println("Value " + entry.getKey() + " has repeated " + entry.getValue() + " times");
			}
		}
	}

	public static void mergeArraysMoveToEnd(int mPlusN[], int size) {

		int i, j = size - 1;
		for (i = size - 1; i >= 0; i--) {
			if (mPlusN[i] != -1) {
				mPlusN[j] = mPlusN[i];
				j--;
			}
		}
		print(mPlusN);

	}

	public static void print(int[] listToSort) {
		for (int el : listToSort) {
			System.out.print(el + ",");
		}
		System.out.println();
	}

	public static int minMoves(int[] nums) {
		// n-2+(max-min)
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int n : nums) {
			if (n < min)
				min = n;
			sum += n;
		}

		return (sum - (nums.length * min));
	}

	public static void missingNumber(int[] array1, int[] array2) {
		int result = 0;
		for (int i = 0; i < array2.length; i++) {
			for (int y = 0; y < array1.length; y++) {
				if ((array2[i] ^ array1[y]) == 0) {
					result = 1;
					System.out.println(array1[i] ^ array2[y]);
					System.out.println(array1[i]+" "+array2[y] );
					continue;
				} else {
					result=0;
				}
			}
			if (result == 0) {
				System.out.println("Fount the missing: "+array2[i]);
				break;
			}
			
		}

	}

	public static void main(String[] args) {
		int array[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int mPlusN[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		int N[] = { 5, 7, 9, 25 };
		int n = N.length;
		int m = mPlusN.length - n;
		mergeArraysMoveToEnd(mPlusN, m + n);
		System.out.println(minMoves(N));
		int array1[] = { 1, 2 };
		int array2[] = { 1 };
		missingNumber(array1, array2);

	}

}
