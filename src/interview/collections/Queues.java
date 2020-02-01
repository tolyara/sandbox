package interview.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
	
	public static void main(String[] args) {
		
		Queue<String> linkedList = new LinkedList<>();
		Deque<String> linkedDeque = new LinkedList<>();
		Deque<String> arrayDeque = new ArrayDeque<>();
		Queue<String> priorityQueue = new PriorityQueue<>();
		
		arrayDeque.add("a");
		arrayDeque.add("c");
		arrayDeque.add("b");
		for (String s : arrayDeque) {
			System.out.println(s);
		}
		System.out.println();
		
		priorityQueue.add("a");
		priorityQueue.add("c");
		priorityQueue.add("b");
		while (priorityQueue.size() != 0) {
			System.out.println(priorityQueue.peek());
		}
		
	}

}
