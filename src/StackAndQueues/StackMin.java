package StackAndQueues;

import java.util.Comparator;

public class StackMin {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>(10);

		stack.push(5);
		stack.push(7);
		stack.push(5);
		stack.push(1);
		stack.push(9);
		
		System.out.format("Min: %s%n", stack.getMin());
		
		for(int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
		
		
	}
	
	

}

class Stack<E extends Comparable<E>> {
	
	private Object[] stack;
	
	private E min;
	
	public Stack(int size) {
		stack = new Object[size];
	}
	
	private int current = 0;
	
	public void push(E e) {
		stack[current] = e;
		
		
		if(current == 0) {
			min = e;
		}
		
		if(current > 0 && e.compareTo(min) < 0) {
			min = e;
		}
		
		current++;
	}
	
	public E pop() {
		
		E e = (E) stack[--current];
		stack[current] = null;
		
		return e;
	}
	
	public E getMin() {
		return min;
	}
	
}