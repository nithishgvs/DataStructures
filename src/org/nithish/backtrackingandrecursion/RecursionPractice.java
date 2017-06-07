package org.nithish.backtrackingandrecursion;

public class RecursionPractice {

	/**
	 * Recursion Practice
	 * 
	 * @param number
	 * @return
	 */
	public static int recursiveSum(int number) {
		if (number == 0) {
			return 0;
		}
		return number + recursiveSum(number - 1);
	}

	public static int SumFunction(int number) {
		if (number == 0) {
			return 0;
		} else {
			int remainder = number / 10;
			int modulo = number % 10;
			return modulo + SumFunction(remainder);
		}

	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static String StringRecursiveReversal(String string) {
		if (string.length() == 0) {
			return string;
		} else {
			return string.substring(string.length() - 1)
					+ StringRecursiveReversal(string.substring(0, string.length() - 1));
		}
	}

	public static String swapString(int x, int y, String string) {
		StringBuffer sb = new StringBuffer(string);
		char temp = string.charAt(x);
		sb.setCharAt(x, string.charAt(y));
		sb.setCharAt(y, temp);
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void StringPermutation(String string,int l,int r) {
		if(l==r)
			System.out.println(string);
		else{
			for(int i=l;i<r;i++){
				string =swapString(i,l,string);
				StringPermutation(string,l+1,r);
				string=swapString(l,i,string);
			}
		}
      
		
		
	}

	public static void main(String[] args) {
		swapString(3, 2, "abcd");
		StringPermutation("abc",0,2);

	}

}
