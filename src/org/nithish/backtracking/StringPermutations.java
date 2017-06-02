package org.nithish.backtracking;

import java.util.*;
import java.lang.*;
import java.io.*;

public class StringPermutations {
	private char[] arrA;

	public void permutation(char[] arrA, int left, int size) {
		int x=0;
		if(x<size){
			
		}
	}

	public void swap(char[] arrA, int i, int j) {
		char temp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = temp;
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		String s = "abc";
		char[] arrCh = s.toCharArray();
		StringPermutations i = new StringPermutations();
		i.permutation(arrCh, 0, arrCh.length);
	}
}
