package org.nithish.dynamicprogramming;

public class Fibonacci {

	static int x = 100;
	static int fib[] = new int[x + 1];

	public static int fibTopDown(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (fib[n] != 0) {
			return fib[n];
		} else {
			fib[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
			return fib[n];
		}
	}

	public static void main(String[] args) {
		System.out.println(fibTopDown(5));

	}

}
