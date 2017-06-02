package org.nithish.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMerging {
	public static void main(String[] main) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(5);
		l1.add(7);
		l1.add(9);
		l1.add(11);
		l2.add(3);
		l2.add(4);
		l2.add(7);
		l2.add(9);
		l2.add(20);
		twoListsAreMerginOrNot(l1, l2);

	}

	public static void twoListsAreMerginOrNot(LinkedList<Integer> l1,
			LinkedList<Integer> l2) {
		LinkedList<Integer> smallerLinkedList = l1;
		LinkedList<Integer> largerLinkedList = l2;
		int difference = l2.size() - l1.size();
		int iterationCount = 0;
		if (difference < 0) {
			smallerLinkedList = l1;
			largerLinkedList = l2;
			difference = Math.abs(difference);
		}
		ListIterator<Integer> smallerIterator = smallerLinkedList
				.listIterator();
		ListIterator<Integer> largerIterator = largerLinkedList.listIterator();
		while (largerIterator.hasNext()) {
			Integer value = largerIterator.next();
			if (iterationCount < difference) {
				iterationCount++;
				continue;
			}
			if (value == smallerIterator.next()) {
				System.out.println("Merging at Integer Value : " + value);
				return;
			}
		}

	}
}
