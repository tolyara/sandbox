package interview.multithreading.lessons.lesson17;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueues {
	
// 	static Queue<String> queue = new PriorityQueue<String>();
	static BlockingQueue<String> queue = new PriorityBlockingQueue<>();

	public static void main(String[] args) {
//		new Adder().start();
//		new Remover().start();

		new Remover().start();
		new Adder().start();
	}

	static class Adder extends Thread {

		@Override
		public void run() {
			String string = "Some string";
			System.out.println("Adding - " + string);
//			queue.add(string);
			try {
				queue.put(string);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	static class Remover extends Thread {

		@Override
		public void run() {
			try {
				System.out.println("Removing - " + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
