package interview.multithreading.lessons.lessons1_8;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {
	
//	static int var;
	static AtomicInteger var = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException { 
		for (int i = 0; i < 10_000; i++) {
			new MyThread().start();
		}
		Thread.sleep(2000);
		System.out.println(var);
	}
	
	static class MyThread extends Thread {

		@Override
		public void run() {			
//			var++;
			var.incrementAndGet();
		}
		
	}

}
