package interview.java8.lessons.lesson2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParallelStreams {
	
	private static final int MAX = 10_000_000;
	
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<Integer>();
		
		for (int i = 0; i < MAX; i++) {
			integers.add(i);
			integers.add(MAX - i);
		}
		
//		long start = System.currentTimeMillis();
		System.out.println(new Date());
		
//		integers.stream().sorted().filter(x -> x%2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
		integers.parallelStream().sorted().filter(x -> x%2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
		
//		long finish = System.currentTimeMillis();
		System.out.println(new Date());
		
//		System.out.println((finish - start) + " millis");
	}

}
