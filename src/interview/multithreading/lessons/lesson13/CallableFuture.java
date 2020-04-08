package interview.multithreading.lessons.lesson13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFuture {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> callable = new MyCallable();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		new Thread(futureTask).start();
		System.out.println("future = " + futureTask.get());
	}
	
	static class MyCallable implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int var = 0;
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				Thread.sleep(50);
				var++;
			}
			return var;
		}		
		
	}

}
