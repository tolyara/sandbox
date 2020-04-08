package interview.multithreading.lessons.lesson8;

public class Deadlock {
	
	public static void main(String[] args) {
		ResourceA resourceA = new ResourceA();
		ResourceB resourceB = new ResourceB();
		resourceA.resourceB = resourceB;
		resourceB.resourceA = resourceA;
		
		MyThread1 myThread1 = new MyThread1();
		MyThread2 myThread2 = new MyThread2();
		myThread1.resourceA = resourceA;
		myThread2.resourceB = resourceB;
		myThread1.start();
		myThread2.start();
	}

}

class MyThread1 extends Thread {
	
	ResourceA resourceA;
	
	@Override
	public void run() {			
		System.out.println(resourceA.getExternalResource());
	}
	
}

class MyThread2 extends Thread {
	
	ResourceB resourceB;
	
	@Override
	public void run() {			
		System.out.println(resourceB.getExternalResource());
	}
	
}

class ResourceA {
	
	ResourceB resourceB;
	
	synchronized String getResource() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "A";
	}
	
	synchronized String getExternalResource() {
		return resourceB.getResource();
	}
 	
}

class ResourceB {
	
	ResourceA resourceA;
	
	synchronized String getResource() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "B";
	}
	
	synchronized String getExternalResource() {
		return resourceA.getResource();
	}
	
}