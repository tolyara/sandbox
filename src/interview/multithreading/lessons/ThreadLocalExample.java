package interview.multithreading.lessons;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadLocalExample {

	static ThreadLocal<String> threadLocal = new ThreadLocal<>();  // each thread will have its own value
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		threadLocal.set("main");

		FutureTask<String> futureTask1 = new FutureTask<String>(new MyCallable("One"));
		FutureTask<String> futureTask2 = new FutureTask<String>(new MyCallable("Two"));
		Thread thread1 = new Thread(futureTask1);
		Thread thread2 = new Thread(futureTask2);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		String result1 = futureTask1.get();
		String result2 = futureTask2.get();

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(Thread.currentThread().getName() + " - " + threadLocal.get());
	}

}

class MyCallable implements Callable<String> {

	private final String value;

	MyCallable(String value) {
		this.value = value;
	}

	@Override
	public String call() {
		ThreadLocalExample.threadLocal.set(value);
		return Thread.currentThread().getName() + " - " + ThreadLocalExample.threadLocal.get();
	}

}

