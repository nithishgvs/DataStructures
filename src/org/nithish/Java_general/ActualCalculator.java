package org.nithish.Java_general;

public class ActualCalculator {

	public int SumMultiply(int a, int b) {
		int res = cal.AddMethod(a, b);
		res = res * res;
		System.out.println(res);
		return res;
	}

	public CalculatorService getCal() {
		return cal;
	}

	public void setCal(CalculatorService cal) {
		this.cal = cal;
	}

	CalculatorService cal ;

}
