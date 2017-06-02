package org.nithish.sorting;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] array = { 1, 4, 5, 7, 10, 6, 2, 9, 3, 8 };
		System.out.println("Before Sorting");
		printSortedList(array);
		System.out.println();
		System.out.println("####After quick Sort####");
		quickSort(array,0,array.length-1);
		printSortedList(array);

	}

	/**
	 * 
	 * @param array
	 */
	private static void insertionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}

		}
		printSortedList(array);

	}

	/**
	 * 
	 * @param array
	 */
	private static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean swapped = false;
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
					swapped = true;
				}

			}
		}
		printSortedList(array);
	}

	private static void printSortedList(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "->");
		}
	}

	/**
	 * 
	 * @param array
	 */
	private static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					swap(array, i, j);
				}
			}
		}
		printSortedList(array);
	}

	/**
	 * Split method for MergeSort
	 * 
	 * @param listToSort
	 * @param firstHalf
	 * @param secondHalf
	 */
	public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
		int index = 0;
		int secondHalfStartIndex = listFirstHalf.length;
		for (int elements : listToSort) {
			if (index < secondHalfStartIndex) {
				listFirstHalf[index] = listToSort[index];
			} else {
				listSecondHalf[index - secondHalfStartIndex] = listToSort[index];
			}
			index++;
		}
	}

	/**
	 * Merge method for MergeSort
	 * 
	 * @param listToSort
	 * @param firstHalf
	 * @param secondHalf
	 */
	public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
		int mergeIndex = 0;
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;

		while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {
			if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
				listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
				firstHalfIndex++;
			} else if (secondHalfIndex < listSecondHalf.length) {
				listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
				secondHalfIndex++;
			}
			mergeIndex++;
		}

		if (firstHalfIndex < listFirstHalf.length) {
			while (mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
			}
		}
		if (secondHalfIndex < listSecondHalf.length) {
			while (mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];
			}
		}
	}

	/**
	 * MergeSort Method
	 * 
	 * @param listToSort
	 */
	public static void mergeSort(int[] listToSort) {
		if (listToSort.length == 1) {
			return;
		}

		int midIndex = listToSort.length / 2 + listToSort.length % 2;
		int[] listFirstHalf = new int[midIndex];
		int[] listSecondHalf = new int[listToSort.length - midIndex];
		split(listToSort, listFirstHalf, listSecondHalf);

		mergeSort(listFirstHalf);
		mergeSort(listSecondHalf);

		merge(listToSort, listFirstHalf, listSecondHalf);
		print(listToSort);
	}

	public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

	public static void print(int[] listToSort) {
		for (int el : listToSort) {
			System.out.print(el + ",");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param sortedList
	 * @param element
	 */
	public static void binarySearch(int[] sortedList, int element) {

		int min = 0;
		int max = sortedList.length - 1;
		while (min <= max) {
			int mid = max - min / 2 + min;
			if (sortedList[mid] == element) {
				System.out.println("Element Found at: " + mid + " Index");
				return;
			}
			if (sortedList[mid] > element) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println("Element Not Found");
	}

	/**
	 * QuickSort Partition
	 * 
	 * @param listToSort
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int[] listToSort, int low, int high) {
		int h = high;
		int l = low;
		int pivot = listToSort[low];
		while (l < h) {
			while (listToSort[l] <= pivot && l < h) {
				l++;
			}
			while (listToSort[h] > pivot) {
				h--;
			}
			if (l < h) {
				swap(listToSort, l, h);
			}

		}
		swap(listToSort, low, h);
		System.out.println("Pivot: " + pivot);
		print(listToSort);
		return h;
	}
	

	/**
	 * QuickSort
	 * 
	 * @param listToSort
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] listToSort, int low, int high) {
		if (low >= high) {
			return;
		}
		int pivot = partition(listToSort, low, high);
		quickSort(listToSort, low, pivot - 1);
		quickSort(listToSort, pivot + 1, high);
	}

}
