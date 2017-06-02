package org.nithish.heap;

import java.util.ArrayList;

import org.nithish.heap.Heap.HeapEmptyException;
import org.nithish.heap.Heap.HeapFullException;

public class connectNRopesMinCost {
	
	public static int[] array={4,3,2,6};

	

	private static void minCostExtraction() throws HeapFullException, HeapEmptyException {
		MinHeap<Integer> minHeap=new MinHeap<>(Integer.class);
		for(Integer i:array){
			minHeap.insert(i);
		}
		ArrayList<Integer> aList=new ArrayList<>();
		int totalValue = 0;
		int bigTotal=0;
		while(!minHeap.isEmpty()){
			aList.add((int)minHeap.removeHighestPriority());
			if(aList.size()==2){
				totalValue=aList.get(0)+aList.get(1);
				aList.removeAll(aList);
				minHeap.insert(totalValue);
				bigTotal+=totalValue;
			}
			
		}
		System.out.println(bigTotal);
		
	}
	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		minCostExtraction();
		

	}

}
