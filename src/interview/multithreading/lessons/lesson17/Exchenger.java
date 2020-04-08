package interview.multithreading.lessons.lesson17;

import java.util.concurrent.Exchanger;

public class Exchenger {
	
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		
		new Student("Mike", exchanger);
		
		new Anket(exchanger);
	}
	
	static class Student extends Thread {
		
		String name;
		
		Exchanger<String> exchanger;

		public Student(String name, Exchanger<String> exchanger) {
			this.name = name;
			this.exchanger = exchanger;
			start();
		}

		@Override
		public void run() {			
			try {
				String answer = exchanger.exchange(("Hi, I am " + name));
				System.out.println(answer);
				sleep(1000);
				exchanger.exchange(("I am 20 years old"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}
	
	static class Anket extends Thread {
				
		Exchanger<String> exchanger;

		public Anket(Exchanger<String> exchanger) {
			this.exchanger = exchanger;
			start();
		}

		@Override
		public void run() {			
			try {
				System.out.println(exchanger.exchange("Hi student! You are enrolled"));
				System.out.println(exchanger.exchange(null));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}
	
}
