package interview.multithreading.lessons.lesson17;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFrameworks {
	
	static long numOfOperations = 2_000_000_000L;
	
	static int numOfProcessorCores = Runtime.getRuntime().availableProcessors();
	
	public static void main(String[] args) {
		long var = 0;
		
		long start = System.currentTimeMillis();
		
//		for (long i = 0; i < numOfOperations; i++) {
//			var += i;
//		}
//		System.out.println(var);
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(numOfProcessorCores);
		System.out.println(forkJoinPool.invoke(new MyFork(0, numOfOperations)));
		
		long finish = System.currentTimeMillis();
		System.out.println();
		System.out.println("time = " + (finish - start) + " ms");
	}
	
	static class MyFork extends RecursiveTask<Long> {
		
		private static final long serialVersionUID = 1L;
		
		long from, to;

		public MyFork(long from, long to) {
			this.from = from;
			this.to = to;
		}

		@Override
		protected Long compute() {			
			if ((to - from) <= numOfOperations/numOfProcessorCores) {
				System.out.println("Computing, numOfOperations = " + numOfOperations + ", from = " + from + ", to = " + to);
				long var = 0;
				for (long i = from; i < to; i++) {
					var += i;
				}
				return var;
			} else {
				System.out.println("Forking, numOfOperations = " + numOfOperations + ", from = " + from + ", to = " + to);
				long middle = (to + from)/2;
				MyFork firstHalf = new MyFork(from, middle);
				firstHalf.fork();
				MyFork secondHalf = new MyFork(middle + 1, to);
				long secondValue = secondHalf.compute();
				return firstHalf.join() + secondValue;
			}
		}
		
	}

}
