package interview.java8.lessons.lesson1;

import java.util.function.Function;

public class FP {
	
	public static void main(String[] args) {
		System.out.println(add.apply(13));
	}
	
	private int square(int x) {
		return x * x;
	}
	
	static Function<Integer, Integer> add = x -> x * x;

}
