package interview.multithreading.lessons.lessons9_16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
	
	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		resource.var = 4;
		resource.var2 = 4;
		
		for (int i = 0; i < 3; i++) {
			MyThread myThread = new MyThread();
			myThread.resource = resource;
			myThread.start();
			myThread.join();
		}
		
		System.out.println(resource.var);
		System.out.println(resource.var2);
	}
	
	static class MyThread extends Thread {
		
		Resource resource;

		@Override
		public void run() {			
			resource.changeVar();
		}
		
	}

}

class Resource {
	
	int var;
	int var2;
	
	Lock lock = new ReentrantLock();
	
	void changeVar() {
		lock.lock();
		
		int var = this.var;
		var++;
		this.var = var;
		
		changeVar2();
//		lock.unlock();
	}
	
	void changeVar2() {
//		lock.lock();
		
		int var2 = this.var2;
		var2++;
		this.var2 = var2;
		
		lock.unlock();
	}
	
}
