package interview.multithreading.lessons.lesson17;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	
	public static void main(String[] args) throws InterruptedException {
		tryReuse();
	}

	private static void success() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);

		new Worker(countDownLatch);
		new Worker(countDownLatch);
		new Worker(countDownLatch);

		System.out.println("countDownLatch.await() call");
		countDownLatch.await();

		System.out.println("All jobs done");
	}

	// only 2 of 3, program freezes
	private static void stuck() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);

		new Worker(countDownLatch);
		new Worker(countDownLatch);

		System.out.println("countDownLatch.await() call");
		countDownLatch.await();

		System.out.println("All jobs done");
	}

	// One cannot reuse the same CountDownLatch once the count reaches 0
	private static void tryReuse() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);

		new Worker(countDownLatch);
		new Worker(countDownLatch);
		new Worker(countDownLatch);

		System.out.println("countDownLatch.await() call 1");
		countDownLatch.await();
		System.out.println("All jobs done 1");

		new Worker(countDownLatch);
		new Worker(countDownLatch);
		new Worker(countDownLatch);

		System.out.println("countDownLatch.await() call 2");
		countDownLatch.await();
		System.out.println("All jobs done 2");

		// countDownLatch.await() call 1
		// Thread-0 finished work
		// Thread-1 finished work
		// Thread-2 finished work
		// All jobs done 1
		// countDownLatch.await() call 2
		// All jobs done 2
		// Thread-4 finished work
		// Thread-3 finished work
		// Thread-5 finished work
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
			e.printStackTrace();
		}
		System.out.println(getName() + " finished work");
		countDownLatch.countDown();
	}

}