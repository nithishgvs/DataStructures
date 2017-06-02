package org.nithish.sorting;

public class BinarySearch {

	public static void binarySearch(int[] array, int element) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = high - low / 2 + low;
			if (element == array[mid]) {
				System.out.println("Element Found At: " + mid);
				break;
			} else if (element > array[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		binarySearch(array, 1);
	}

}
