package interview.multithreading.lessons;

public class Interruptions {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.setDaemon(true);
		
		myThread.start();
		Thread.sleep(100);
		myThread.interrupt();
		printThreadIndicators(myThread);
		
//		System.out.println(Thread.currentThread().holdsLock(args));
	}
	
	private static void printThreadIndicators(Thread thread) {
		System.out.println("Is alive       = " + thread.isAlive());
		System.out.println("Is interrupted = " + thread.isInterrupted());
	}

}
