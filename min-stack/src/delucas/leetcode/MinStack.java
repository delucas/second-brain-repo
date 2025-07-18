package delucas.leetcode;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> elementos = new Stack<Integer>();
	private Stack<Integer> minimo = new Stack<Integer>();
	
	public void push(int elem) {
		elementos.push(elem);
		if (minimo.isEmpty() || elem < minimo.peek()) {
			minimo.push(elem);
		} else {
			minimo.push(minimo.peek());
		}
		
	}

	public int getMin() {
		return minimo.peek();
	}

	public int pop() {
		minimo.pop();
		return elementos.pop();
	}

	public int peek() {
		return elementos.peek();
	}
}
