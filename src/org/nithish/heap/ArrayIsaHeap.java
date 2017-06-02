package org.nithish.heap;

public class ArrayIsaHeap {

	public static int[] arr = { 90, 15, 10, 7, 12, 2 };

	public static boolean isHeap(int[] arr, int n) {
		// Start from root and go till the last internal
		// node
		for (int i = 0; i <= (n - 2) / 2; i++) {
			// If left child is greater, return false
			if (2 * i + 1 < arr.length && arr[2 * i + 1] > arr[i])
				return false;

			// If right child is greater, return false
			if (2 * i + 2 < arr.length && arr[2 * i + 2] > arr[i])
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		boolean val = isHeap(arr, arr.length);
		System.out.println(val);

	}

}
