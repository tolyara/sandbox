package interview.multithreading;

public class WaitNotify {
	
	static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		synchronized (lock) {
			lock.wait();
		}
		System.out.println(myThread.total + " - " + Thread.currentThread().getName());
	}
	
	static class MyThread extends Thread {
		
		int total = 0;
		
		@Override
		public void run() {
			synchronized (lock) {
				for (int i = 0; i < 5; i++) {
					total++;
					System.out.println(total + " - " + Thread.currentThread().getName());
					trySleep();
				}
				lock.notify();
			}
		}
		
		private void trySleep() {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
