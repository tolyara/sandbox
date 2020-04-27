package interview.multithreading.lessons.lessons1_8;

//			Waiting/Blocked/Sleeping
				
//   New    -> Runnable -> Running ->     Dead

public class ThreadLifecycle { 
	
	public static void main(String[] args) throws InterruptedException {
		MyThread3 myThread = new MyThread3();
		myThread.start();
		
//		Thread.sleep(500);
		
//		Thread.yield();
		
		myThread.join();
		
		System.out.println("Thread name : " + Thread.currentThread().getName());
	}

}

class MyThread3 extends Thread {

	@Override
	public void run() {		
//		System.out.println("Thread name : " + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
}