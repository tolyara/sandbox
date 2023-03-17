package interview.multithreading.lessons.lessons9_16;

import java.util.concurrent.Semaphore;

public class Semafors {
	
	public static void main(String[] args) {
//		Semaphore table = new Semaphore(3);
		Semaphore table = new Semaphore(1);

		for (int i = 0; i < 7; i++) {
			Person person = new Person();
			person.table = table;
			person.start();
		}
	}

}

class Person extends Thread {
	
	Semaphore table;

	@Override
	public void run() {
		System.out.println(getName() + " starts waiting for table");
		try {
			table.acquire();
			System.out.println(getName() + " is eating at the table");
			sleep(200);
			System.out.println(getName() + " releases table");
			table.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}