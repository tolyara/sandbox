package interview.multithreading.lessons.lesson17;

public class ThreadFactorys {
	
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		MyThreadFactory myThreadFactory = new MyThreadFactory();
		
		myThreadFactory.newThread(myRunnable).start();
		myThreadFactory.newThread(myRunnable).start();
		myThreadFactory.newThread(myRunnable).start();
	}

}

class MyThreadFactory implements java.util.concurrent.ThreadFactory {

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable);
		thread.setName("NAME");
		thread.setPriority(Thread.MAX_PRIORITY);
		return thread;
	}	
	
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Data, " + Thread.currentThread().getName());
	}
	
}

