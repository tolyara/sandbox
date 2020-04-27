package interview.multithreading.lessons.lessons1_8;

public class ThreadCreation {
	
	public static void main(String[] args) {
//		MyThread myThread = new MyThread();
//		myThread.start();
		
//		MyRunnable myRunnable = new MyRunnable();		
//		Thread thread = new Thread(myRunnable);
//		thread.start();
		
		new MyThreadcreation().start();
		new MyThreadcreation().start();
		new MyThreadcreation().start();
	}

}

class MyThreadcreation extends Thread {

	@Override
	public void run() {		
		System.out.println(Thread.currentThread().getName() + " have been runned");
		for (int i = 0; i < 400; i++) {
			System.out.println(Thread.currentThread().getName());
		}
//		throwException();
	}

	private void throwException() {
		throw new RuntimeException();
	}	
	
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " have been runned");
//		throwException();
	}
	
	private void throwException() {
		throw new RuntimeException();
	}
	
}