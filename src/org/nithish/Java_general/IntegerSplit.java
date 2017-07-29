package org.nithish.Java_general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IntegerSplit {

	public static void SplitIntegers(int totalNum, List<Integer> integerArray) {
		List<Integer> al = integerArray;
		for (int i = 0; i < ((totalNum / 2) + (totalNum % 2)); i++) {
			System.out.print(al.get(i) + " ");
		}
		System.out.println();
		for (int i = ((totalNum / 2) + (totalNum % 2)); i < totalNum; i++) {
			System.out.print(al.get(i) + " ");
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		//SplitIntegers(5, al);
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(Integer.bitCount((int)(1)));
		System.out.println(Math.pow(2, -2));
		System.out.println(Math.ceil(4));
		System.out.println(Math.ceil(Math.pow(2, -2)));
		System.out.println(Integer.bitCount((int)(Math.pow(2, -5))));
		
	}

}
