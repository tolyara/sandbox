package interview.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues {

	public static void main(String[] args) {
//		test1();
		offerVsAdd();
	}

	private static void offerVsAdd() {
		Queue<Car> cars = new ArrayBlockingQueue<>(3);

		Car car1 = new Car("Nissan");
		Car car2 = new Car("BMW");
		Car car3 = new Car("Toyota");
		Car car4 = new Car("Kia");

		cars.offer(car1);
		cars.offer(car2);
		cars.offer(car3);
		cars.offer(car4); // no exception, element just not added to queue
		System.out.println(cars);

		cars.clear();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4); // java.lang.IllegalStateException: Queue full
		System.out.println(cars);
	}

	public static void test1() {
//		Queue<Car> cars = new ArrayBlockingQueue<Car>(3);
		Deque<Car> cars = new ArrayDeque<Car>();

		Car car1 = new Car("Nissan");
		Car car2 = new Car("BMW");
		Car car3 = new Car("Toyota");
		Car car4 = new Car("Kia");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		
//		System.out.println("fifo.element = " + cars.element());
//		System.out.println(cars);
//		System.out.println("fifo.remove = " + cars.remove());
//		System.out.println(cars);
		
//		Queue<Car> cars2 = Collections.asLifoQueue(cars);		
//		System.out.println("lifo.element = " + cars2.element());
//		System.out.println("lifo.remove = " + cars2.remove());
		
//		Deque<Car> cars3 = new LinkedList<Car>();
//		cars3.addFirst(car1);
//		cars3.addFirst(car2);
//		cars3.addLast(car3);
//		cars3.addLast(car4);
//		System.out.println(cars3);
		
		Stack<Car> cars4 = new Stack<Car>();
		cars4.add(car1);
		cars4.add(car2);
		cars4.add(car3);
		cars4.add(car4);
		while (!cars4.empty()) {
			System.out.println(cars4.pop());
		}
	}

	private static void main() {

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

class Car {

	private String name;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}

}
