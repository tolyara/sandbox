package interview.multithreading.lessons.lessons9_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WaitNotify2 {
	
	static List<String> strings = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String[] args) throws InterruptedException {
		new Operator().start();
		new Machine().start();
	}
	
	static class Operator extends Thread {
		
		@Override
		public void run() {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				synchronized (strings) {
					String string = scanner.nextLine();
					strings.add(string);
//					strings.add(string + "2");
//					strings.add(string + "3");
					strings.notify();
				}
				synchronized (strings) {
					try {
						strings.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	static class Machine extends Thread {
		
		@Override
		public void run() {
			while (strings.isEmpty()) {
				synchronized (strings) {
					try {
						strings.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//					System.out.println(strings.remove(0));
				}		
			}
			System.out.println(strings.remove(0));
			synchronized (strings) {
				strings.notifyAll();
			}			
		}
		
	}

}
