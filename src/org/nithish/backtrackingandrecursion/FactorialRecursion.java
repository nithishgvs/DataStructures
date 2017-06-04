package org.nithish.backtrackingandrecursion;

public class FactorialRecursion {

	public static int factorialRecursive(int n) {
		if (n == 1) {
			return 1;
		} else {
			System.out.println("Recursive Call where n: "+n);
			return n * factorialRecursive(n - 1);
		}

	}

	public static void main(String[] args) {
		System.out.println(factorialRecursive(5));

	}

}
