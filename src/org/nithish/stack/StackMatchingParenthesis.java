package org.nithish.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StackMatchingParenthesis {

	public static final Map<Character, Character> matchingParenthesisMap = new HashMap<Character, Character>();
	public static final Set<Character> openingParenthesis = new HashSet<Character>();

	static {
		matchingParenthesisMap.put('}', '{');
		matchingParenthesisMap.put(')', '(');
		matchingParenthesisMap.put(']', '[');
		openingParenthesis.addAll(matchingParenthesisMap.values());
	}

	public boolean checkMatchingParenthesis(String expression) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expression.length(); i++) {
			char character = expression.charAt(i);
			if (openingParenthesis.contains(character)) {
				try {
					stack.push(character);
				} catch (StackOverFlowException e) {
					System.out.println("Stack OverFlow Error");
				}
			}
			if (matchingParenthesisMap.containsKey(character)) {
				try {
					char topOfStack = stack.pop();
					if (matchingParenthesisMap.get(character) != topOfStack) {
						return false;
					}
				} catch (StackUnderFlowException e) {
					System.out.println("Stack OunderFlow Error");
				}
			}
		}
		return stack.isEmpty();

	}

}
