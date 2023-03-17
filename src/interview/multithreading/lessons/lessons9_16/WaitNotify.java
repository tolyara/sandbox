package interview.multithreading.lessons.lessons9_16;

public class WaitNotify {
	
	static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		synchronized (lock) {
			// increment one time and give control to myThread
			myThread.total++;
			System.out.println(myThread.total + " - " + Thread.currentThread().getName());

//			lock.wait();
			lock.wait(20); // main thread will still wait after timeout time elapsed so it will work exactly as lock.wait();
		}
		System.out.println(myThread.total + " - " + Thread.currentThread().getName());
	}
	
	static class MyThread extends Thread {
		
		int total = 0;
		
		@Override
		public void run() {
			synchronized (lock) {
				for (int i = 1; i < 5; i++) {
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
