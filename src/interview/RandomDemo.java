package interview;

import java.util.Random;

public class RandomDemo {
	
	public static void main(String[] args) {
		
		final Random random = new Random();
		for (int i = 0; i < 15; i++) {
			System.out.println(random.nextInt(5));
		}
		
	}

}
