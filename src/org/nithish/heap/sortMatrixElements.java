package org.nithish.heap;

import java.util.ArrayList;

import org.nithish.heap.Heap.HeapEmptyException;
import org.nithish.heap.Heap.HeapFullException;

public class sortMatrixElements {

	public static int marks[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

	@SuppressWarnings("unchecked")
	public static void sortMatrixElements(int[][] marks) throws HeapFullException, HeapEmptyException {
		MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, 16);
		ArrayList<Integer> aList = new ArrayList<Integer>();
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				minHeap.insert(marks[j][i]);
			}
		}
		while (!minHeap.isEmpty()) {
			aList.add((int) minHeap.removeHighestPriority());
		}
		for (int i=0;i<aList.size();i++) {
			System.out.print(aList.get(i)+"->");
		}
	}

	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		sortMatrixElements(marks);
	}

}
