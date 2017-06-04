package org.nithish.backtrackingandrecursion;

public class TowersofHanoi {

	public static void TowersofHanoiRecursive(int n, char from, char using, char to) {
		if (n == 1) {
			System.out.println("Moving disk  from" + from + " to " + to);
		} else {
			TowersofHanoiRecursive(n - 1, from, to, using);
			System.out.println("Moving disk  from" + from + " to " + to);
			TowersofHanoiRecursive(n - 1, using, from, to);
		}

	}

	public static void main(String[] args) {
		TowersofHanoiRecursive(3, 'A', 'B', 'C');

	}

}
