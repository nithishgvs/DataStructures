package org.nithish.arrays;

import java.io.*;
import java.util.*;

public class MainClass {

	static int convert6To5Rec(int num) {
		// Base case for recursion termination
		if (num == 0)
			return 0;

		// Extraxt the last digit and change it if needed
		int digit = num % 10;
		if (digit == 6)
			digit = 5;

		// Convert remaining digits and append the last digit
		return convert6To5Rec(num / 10) * 10 + digit;
	}

	static int convert5To6Rec(int num) {
		// Base case for recursion termination
		if (num == 0)
			return 0;

		// Extraxt the last digit and change it if needed
		int digit = num % 10;
		if (digit == 5)
			digit = 6;

		// Convert remaining digits and append the last digit
		return convert5To6Rec(num / 10) * 10 + digit;
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println(convert6To5Rec(55));
		List<String> inputByLine = new ArrayList<String>();
		try {
			// Get the object of DataInputStream
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			while ((line = br.readLine()) != null) {
				inputByLine.add(line.toString());
				String[] chars = line.toString().split(" ");
				System.out.println(Integer.parseInt(chars[0]));
				ArrayList<Integer> al1 = new ArrayList<>();
				al1.add((Integer.parseInt(chars[0])));

				int newnum5 = convert6To5Rec(Integer.parseInt(chars[0]));
				if (newnum5 != Integer.parseInt(chars[0])) {
					al1.add(newnum5);
				}
				int newnum6 = convert5To6Rec(Integer.parseInt(chars[0]));
				if (newnum6 != Integer.parseInt(chars[0])) {
					al1.add(newnum6);
				}

				ArrayList<Integer> al2 = new ArrayList<>();
				al2.add((Integer.parseInt(chars[1])));

				newnum5 = convert6To5Rec(Integer.parseInt(chars[1]));
				if (newnum5 != Integer.parseInt(chars[1])) {
					al2.add(newnum5);
				}
				newnum6 = convert5To6Rec(Integer.parseInt(chars[1]));
				if (newnum6 != Integer.parseInt(chars[1])) {
					al2.add(newnum6);
				}

				int max = 1;
				int min = 100000;

				/*for (int i = 0; i < i1.length; i++) {
					for (int j = 0; j < i1.length; i++) {
						int temp = i1[i] + i2[j];
						if (temp < min) {
							min = temp;
						} else if (temp > max) {
							max = temp;
						}
					}
				}*/

				System.out.println(max + " " + min);

			}
			for (String line2 : inputByLine)
				System.out.println(line2);
			isr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}