package interview.multithreading.lessons;

public class ThreadStatus {
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		System.out.println(myThread.getState());		
		myThread.start();
		System.out.println(myThread.getState());
	}

}











//Field field = Thread.class.getDeclaredField("threadStatus");
//field.setAccessible(true);
//System.out.println(field.get(myThread));