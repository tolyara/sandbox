package interview.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class CollectionsLesson {

	public static void main(String[] args) {

		Lesson2();

	}

	private static void Lesson1() {

		Queue<String> queue = new LinkedList<String>();
		queue.add("zero");
		queue.add("one");

		System.out.println(queue.offer("two"));
//		System.out.println(queue.poll());
		System.out.println(queue.size());

	}

	private static void collection() {

		Collection<String> collection = new ArrayList<String>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		collection.add("2");
		collection.add("4");
//		collection.remove("2");
//		collection.remove("2");
		System.out.println(collection);

	}

	private static void Lesson2() {

		TreeSet<A> treeSet = new TreeSet<A>();
		treeSet.add(new A());
		treeSet.add(new A());
		for (A a : treeSet) {
			System.out.println(a);
		}

	}

}

class A implements Comparable {

	@Override
	public int compareTo(Object o) {
		return this.hashCode() - o.hashCode();
	}

}
