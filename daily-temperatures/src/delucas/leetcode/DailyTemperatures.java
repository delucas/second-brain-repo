package delucas.leetcode;

import java.util.Stack;

public class DailyTemperatures {

	public static int[] findWarmerDays(int[] temperatures) {
		int[] result = new int[temperatures.length];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for (int i = 1; i < result.length; i++) {
			while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				result[stack.peek()] = i-stack.peek();
				stack.pop();
			}
			stack.push(i);
		}		
		return result;
	}

}
