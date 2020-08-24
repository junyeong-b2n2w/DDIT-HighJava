package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackQueueTest {

	
	public static void main(String[] args) {
		
		/*
		 * 
		 */
		
		LinkedList<String> stack = new LinkedList<>();
		
		stack.push("hi");
		stack.push("hello");
		stack.push("geiei");
		stack.push("sdfs");
		stack.push("haaaao");
	
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("aaaaa");
		queue.offer("bbbbb");
		queue.offer("ccccc");
		queue.offer("ddddd");
		
		System.out.println("ÇöÀç queue °ª : " + queue);
		
		
		
		
		
	}
}
