package interview.multithreading.lessons.lesson17;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomAndTimeUnit {
	
	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println(ThreadLocalRandom.current().nextInt());
		
		System.out.println(TimeUnit.DAYS.toSeconds(14));
		System.out.println(TimeUnit.SECONDS.toDays(86_400));
	}

}
