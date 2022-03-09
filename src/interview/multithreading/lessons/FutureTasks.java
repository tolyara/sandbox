package interview.multithreading.lessons;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTasks {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Adder adder = new Adder(3, 7);
		FutureTask<Integer> task = new FutureTask<Integer>(adder);
		
		Thread thread = new Thread(task);
		thread.start();
		
		int result = task.get();
		System.out.println(result);
	}

}

class Adder implements Callable<Integer> {
	
	int a;
	
	int b;

	public Adder(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() {
		return a + b;
	}
	
}
