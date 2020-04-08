package interview.multithreading.lessons.lesson17;

import java.util.concurrent.CountDownLatch;

public class CountDownLach {
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		new Worker(countDownLatch);
		new Worker(countDownLatch);
		new Worker(countDownLatch);
		
		countDownLatch.await();
		
		System.out.println("All jobs done");
	}
}

class Worker extends Thread {
	
	CountDownLatch countDownLatch;

	public Worker(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
		start();
	}

	@Override
	public void run() {
		try {
			sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName() + " finished work");
		countDownLatch.countDown();
	}

}