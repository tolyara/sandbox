package interview.collections;

import java.util.LinkedList;
import java.util.Queue;

public class CollectionsLesson {

	public static void main(String[] args) {
		
		Lesson1();
		
	}
	
	private static void Lesson1() {
		
		Queue<String> queue = new LinkedList<String>();
		queue.add("zero");
		queue.add("one");
		
		System.out.println(queue.offer("two"));
//		System.out.println(queue.poll());
		System.out.println(queue.size());
		
	}
	
}
