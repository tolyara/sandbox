package interview.java8.lessons.lesson1;

import java.awt.event.ActionListener;

public class Lambdas {
	
//	static String string = "qwer";
	
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = () -> System.out.println("Hello");
		
		Thread thread = new Thread(runnable);
		thread.start();
		thread.join();
		
		String string = "qwer"; //final
//		string = "new qwer";
		ActionListener actionListener = (event) -> System.out.println(string);
		
		System.out.println("After");
	}
	
	private static void old() { 
		Runnable runnable = new Runnable() {			
			@Override
			public void run() {
				System.out.println("Hello");
			}
		};
	}

}
