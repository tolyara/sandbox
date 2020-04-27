package interview.multithreading.lessons.lessons9_16;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsMain {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new MyRunnable());
		System.out.println(executorService.submit(new MyCallable()).get());
		executorService.shutdown();
	}
	
	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(1);
		}		
		
	}
	
	static class MyCallable implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
//			Thread.sleep(1000);
			return 2;
		}		
		
	}

}
