package interview.multithreading.lessons.lessons9_16;

public class WaitVsSleep {
	
	static final Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		synchronized (lock) {
			lock.wait(30); 				// main thread will still wait after timeout time elapsed
			// 1 - Thread-0
			// 2 - Thread-0
			// 3 - Thread-0
			// 3 - main

//			Thread.sleep(30);		// main thread will wake up and continue it's work after timeout time elapsed
			// 1 - main
			// 1 - Thread-0
			// 2 - Thread-0
			// 3 - Thread-0
		}
		System.out.println(myThread.total + " - " + Thread.currentThread().getName());
	}
	
	static class MyThread extends Thread {
		
		int total = 0;
		
		@Override
		public void run() {
			synchronized (lock) {
				for (int i = 0; i < 3; i++) {
					total++;
					System.out.println(total + " - " + Thread.currentThread().getName());
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				lock.notify();
			}
		}
		
	}

}
