package interview.multithreading.lessons.lesson3;

public class Syncronization {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		resource.var = 1;

//		MyThread myThread = new MyThread(resource);
//		myThread.setName("one");
//		MyThread myThread2 = new MyThread(resource);
//		myThread.start();
//		myThread2.start();
//		myThread.join();
//		myThread2.join();

		for (int i = 0; i < 2_000; i++) {
			MyThread myThread = new MyThread(resource);
			myThread.start();
			myThread.join();
		}

		System.out.println(resource.var);
	}

}

class MyThread extends Thread {

	Resource resource;

	public MyThread(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.incrementVar();
	}

}

class Resource {

	int var;

//	public synchronized void incrementVar() {
	public void incrementVar() {
		synchronized (this) {
			int i = var;
//		if (Thread.currentThread().getName().equals("one")) {
//			Thread.yield();
//		}		 
			i++;
			var = i;
		}
	}

}

//var++;
//var--;
//
//var++;
//var--;
//
//var++;
//var--;
//
//var++;
//var--;
