package interview.multithreading.lessons.lessons1_8;

public class Syncronization {

	public static void main(String[] args) throws InterruptedException {
		Resource2 resource = new Resource2();
		resource.var = 1;

//		MyThread myThread = new MyThread(resource);
//		myThread.setName("one");
//		MyThread myThread2 = new MyThread(resource);
//		myThread.start();
//		myThread2.start();
//		myThread.join();
//		myThread2.join();

		for (int i = 0; i < 2_000; i++) {
			MyThreadSync myThread = new MyThreadSync(resource);
			myThread.start();
			myThread.join();
		}

		System.out.println(resource.var);
	}

}

class MyThreadSync extends Thread {

	Resource2 resource;

	public MyThreadSync(Resource2 resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.incrementVar();
	}

}

class Resource2 {

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
