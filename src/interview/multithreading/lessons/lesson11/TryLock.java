package interview.multithreading.lessons.lesson11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {

	static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		new MyThread1().start();
		new MyThread2().start();
	}

	static class MyThread1 extends Thread {

		@Override
		public void run() {
			lock.lock();
			System.out.println(getName() + " start working...");
			try {
				sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " stop working");
			lock.unlock();
			System.out.println(getName() + " lock is released");
		}

	}
	
	static class MyThread2 extends Thread {

		@Override
		public void run() {
			System.out.println(getName() + " start working");
			while (true) {
				if (lock.tryLock()) {
					System.out.println(getName() + " working...");
					break;
				} else {
					System.out.println(getName() + " waiting...");
				}
			}
		}

	}

}
