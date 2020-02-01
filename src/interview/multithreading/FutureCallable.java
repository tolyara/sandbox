package interview.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
//		Collections.unmodifiableList(list)
		
//		executorService.execute(new MyRunnable());
//		Future<?> future = executorService.submit(new MyRunnable());		
//		while (!future.isDone()) {
//			System.out.println("Is not done");
//			Thread.sleep(100);
//		}
		
		Future<Integer> future = executorService.submit(new MyCallable());
		Thread.sleep(100);
		future.cancel(true);
		System.out.println(future.isCancelled());
//		Integer result = future.get();
//		System.out.println(result);
		
		System.out.println("Prepare to shutdown...");
		executorService.shutdown();
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Started - " + Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Finished - " + Thread.currentThread().getId());
	}	
	
}

class MyCallable implements Callable<Integer> {

	@Override
	public Integer call() {
		System.out.println("Started - " + Thread.currentThread().getId());
		try {
			Thread.sleep(1);
			long current1 = System.currentTimeMillis();
			long current2 = System.currentTimeMillis();
			while (current2 < current1 + 5000) {
				current2 = System.currentTimeMillis();
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
			e.printStackTrace(System.out);
		}
		System.out.println("Finished - " + Thread.currentThread().getId());
		return 99;
	}	
	
}




