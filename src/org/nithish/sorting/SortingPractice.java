package org.nithish.sorting;

public class SortingPractice {

	public static void BubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j - 1, j);
				}
			}
		}
		print(array);
	}

	public static void SelectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					swap(array, i, j);
				}
			}
		}
		print(array);
	}

	public static void InsertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}
		print(array);
	}

	public static void QuickSort(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}
		int pivot = Partition(array, low, high);
		QuickSort(array, low, pivot);
		QuickSort(array, pivot + 1, high);

	}

	private static int Partition(int[] array, int low, int high) {
		int l = low;
		int h = high;
		int pivot = array[low];
		while (l < h) {
			while (pivot >= array[l] && l < h) {
				l++;
			}
			while (pivot < array[h]) {
				h--;
			}
			if (l < h) {
				swap(array, low, h);
			}
		}
		swap(array, low, h);
		System.out.println("Pivot: " + pivot);
        print(array);
		return h;
	}

	public static void main(String[] args) {
		int[] array = { 5, 4, 3, 2, 1 };
		/*
		 * long start_time = System.nanoTime(); BubbleSort(array); long end_time
		 * = System.nanoTime(); System.out.println("Bubble Sort Run time: " +
		 * (end_time - start_time) / 1e6); start_time = System.nanoTime();
		 * SelectionSort(array); end_time = System.nanoTime();
		 * System.out.println("Selection Sort Sort Run time: " + (end_time -
		 * start_time) / 1e6); start_time = System.nanoTime();
		 * InsertionSort(array); end_time = System.nanoTime();
		 * System.out.println("Insertion Sort Sort Run time: " + (end_time -
		 * start_time) / 1e6);
		 */
		QuickSort(array, 0, array.length - 1);
	}

	public static void print(int[] listToSort) {
		for (int el : listToSort) {
			System.out.print(el + ",");
		}
		System.out.println();
	}

	public static void swap(int[] listToSort, int iIndex, int jIndex) {
		int temp = listToSort[iIndex];
		listToSort[iIndex] = listToSort[jIndex];
		listToSort[jIndex] = temp;
	}

}
