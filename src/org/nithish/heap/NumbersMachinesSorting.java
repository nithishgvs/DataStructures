package org.nithish.heap;

import java.util.ArrayList;
import java.util.LinkedList;

import org.nithish.heap.Heap.HeapEmptyException;
import org.nithish.heap.Heap.HeapFullException;

public class NumbersMachinesSorting {

	@SuppressWarnings("unchecked")
	public static void machineNumbersSorting(LinkedList<Integer> l1, LinkedList<Integer> l2, LinkedList<Integer> l3)
			throws HeapFullException, HeapEmptyException {
		MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, 3);
		ArrayList<Integer> alist = new ArrayList<>();
		minHeap.insert((int) l1.removeFirst());
		minHeap.insert((int) l2.removeFirst());
		minHeap.insert((int) l3.removeFirst());
		while (!minHeap.isEmpty()) {
			alist.add((int) minHeap.removeHighestPriority());
			if (!l1.isEmpty()) {
				minHeap.insert((int) l1.removeFirst());
			} else if (!l2.isEmpty()) {
				minHeap.insert((int) l2.removeFirst());
			} else if (!l3.isEmpty()) {
				minHeap.insert((int) l3.removeFirst());
			}
		}
		for(Integer i:alist){
			System.out.print(i+"->");
		}

	}

	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		LinkedList<Integer> machine1 = new LinkedList<>();
		machine1.add(30);
		machine1.add(40);
		machine1.add(50);
		LinkedList<Integer> machine2 = new LinkedList<>();
		machine2.add(35);
		machine2.add(45);
		LinkedList<Integer> machine3 = new LinkedList<>();
		machine3.add(10);
		machine3.add(60);
		machine3.add(70);
		machine3.add(80);
		machine3.add(100);
		machineNumbersSorting(machine1,machine2,machine3);

	}

}
