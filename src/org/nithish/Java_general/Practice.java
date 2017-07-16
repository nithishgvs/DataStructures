package org.nithish.JavaGeneral;

public class Practice {

	public static int reverseInteger(int k) {

		int rem = 0;
		while (k > 0) {
			rem = rem * 10 + (k % 10);
			k = k / 10;
		}
		return rem;

	}

	public static void main(String[] args) {
		int y = reverseInteger(155);
		System.out.println(y);

	}

}
