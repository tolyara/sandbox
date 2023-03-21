package interview.multithreading.lessons.lesson17;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBarrierExample {
	
	public static void main(String[] args) {
//		success();
//		stuck();
		stuck2();
	}

	private static void success() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
		new Runner(cyclicBarrier);
		new Runner(cyclicBarrier);
		new Runner(cyclicBarrier);
	}

	private static void stuck() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
		new Runner(cyclicBarrier);
		new Runner(cyclicBarrier);
	}

	private static void stuck2() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
		new Runner(cyclicBarrier);
		new Runner(cyclicBarrier);
		new Runner(cyclicBarrier);
		new Runner(cyclicBarrier);
	}
	
	static class Run extends Thread {
				
		@Override
		public void run() {	
			System.out.println("Run is begun");
		}
		
	}
	
	static class Runner extends Thread {
		
		CyclicBarrier cyclicBarrier;
		
		public Runner(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
//			setDaemon(true);
			start();			
		}

		@Override
		public void run() {	
			System.out.println("Runner waiting...");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}

}
