package interview.java8.lessons.lesson2;

import java.util.stream.Stream;

public class HowLambdaWorks {
	
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("a", "b", "c");
		stream.map(s -> { 							// intermediate
			System.out.println("Map " + s);
			return s.toLowerCase();
		}).map(s -> { 							// intermediate
			System.out.println("Map2 " + s);
			return s.toUpperCase();
		})
		.forEach(s-> System.out.println("Foreach" + s));		// terminal
	}

}
