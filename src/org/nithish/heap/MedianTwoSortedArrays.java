package org.nithish.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianTwoSortedArrays {

	public static void MedianofTwoSortedArrays(int[] array1, int[] array2) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer int1, Integer int2) {
				return (int1.compareTo(int2));
			}
		});
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer int1, Integer int2) {
				return (int2.compareTo(int1));
			}
		});

		for (int i = 0; i < array1.length; i++) {
			maxHeap.add(array1[i]);
		}
		for (int i = 0; i < array2.length; i++) {
			minHeap.add(array2[i]);
		}
		while (maxHeap.peek() > minHeap.peek()) {
			int temp = maxHeap.poll();
			maxHeap.add(minHeap.poll());
			minHeap.add(temp);
		}

		if ((maxHeap.size() - minHeap.size()) == 2) {
			minHeap.add(maxHeap.poll());
		} else if (minHeap.size() - maxHeap.size() == 2) {
			maxHeap.add(minHeap.poll());
		}

		if (maxHeap.size() == minHeap.size()) {
			System.out.println("Median is :" + ((minHeap.peek() + maxHeap.peek()) / 2));
		} else if (maxHeap.size() > minHeap.size()) {
			System.out.println("Median is :" + maxHeap.peek());
		} else if (maxHeap.size() < minHeap.size()) {
			System.out.println("Median is :" + minHeap.peek());
		}
	}

	public static void main(String[] args) {
		int[] array2 = { 1, 2, 3 };
		int[] array1 = { -6, -7, 800, 9, 10 };
		MedianofTwoSortedArrays(array1, array2);

	}

}
