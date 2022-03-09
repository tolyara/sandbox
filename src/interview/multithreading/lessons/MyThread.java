package interview.multithreading.lessons;

public class MyThread extends Thread {
	
	@Override
	public void run() {
//		Thread.interrupted();
		while (true) {
			System.out.println("Running...");
			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace(System.out);
			}
		}
	}
	
}
