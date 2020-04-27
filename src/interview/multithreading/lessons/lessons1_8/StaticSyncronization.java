package interview.multithreading.lessons.lessons1_8;

// Synchronization must be static or non-static, never together!!!
public class StaticSyncronization {

	public static void main(String[] args) throws InterruptedException {
		Resource.var = 1;

		for (int i = 0; i < 2_000; i++) {
			MyThread myThread = new MyThread();
			myThread.start();
			myThread.join();
		}

		System.out.println(Resource.var);
	}

}

class MyThread extends Thread {

	Resource resource;

	public MyThread(Resource resource) {
		this.resource = resource;
	}

	public MyThread() {

	}

	@Override
	public void run() {
		Resource.incrementVar();
	}

}

class Resource {

	static int var;

	public static void incrementVar() {
		synchronized (Resource.class) {
			int i = var;
			i++;
			var = i;
		}
	}

}

//