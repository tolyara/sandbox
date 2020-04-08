package interview.java8.lessons.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
	
	private static Stream<String> stream = Stream.of("one", "two", "three");
//	private static Stream<String> stream = Arrays.asList("one", "two", "three").stream();
	
	public static void main(String[] args) {
		
		stream2();
		
	}
	
	private static void stream() {
		
//		stream.forEach(element -> System.out.println(element));
//		stream.forEach(element -> System.out.println(element));			exception
		
//		stream = list.stream();
//		stream.forEach(element -> System.out.println(element));
		
//		list.stream().filter(x -> x.equals("111"));
//		stream.filter(x -> {
//			System.out.println(x);
//			return x.equals("111");		// lazy
//		})
//		.count() 	// eager
//		;
		
		
		
//		Set<String> set = stream.filter(x -> x.equals("111")).collect(Collectors.toSet());
		
//		stream.map(x -> x.toUpperCase()).forEach(element -> System.out.println(element));
		
		Stream.of(Arrays.asList("one", "two"), Arrays.asList("three", "four")).flatMap(x -> x.stream())
			.forEach(element -> System.out.println(element));
		
//		int min = Stream.of(1, 2, 4, 0).min(Comparator.comparing(x -> x)).get();
//		int max = Stream.of(1, 2, 8, 3).max(Comparator.comparing(x -> x)).get();
//		System.out.println(min);
//		System.out.println(max);
		
		

		
	}
	
	private static void stream2() {
		
//		List<Integer> list = Stream.of(1, 2, 4, 0).sorted().collect(Collectors.toList());
		
//		List<Integer> list = Stream.of(1, 2, 4, 0).limit(2).collect(Collectors.toList());
		
//		List<Integer> list = Stream.of(1, 2, 4, 4).distinct().collect(Collectors.toList());
		
//		List<Integer> list = Stream.of(1, 2, 4, 4).skip(1).collect(Collectors.toList());
		
//		Integer element = Stream.of(1, 2, 3, 4).filter(x -> x > 2).findFirst().get();
//		boolean element = Stream.of(1, 2, 3, 4).filter(x -> x > 2).findAny().isPresent();
		
//		int element = Stream.of(1, 2, 3, 4).mapToInt(x -> x).sum();  // convert Integer to int
		
//		long element = Stream.of(1, 2, 1, 2, 1, 2).count();
		
//		List<String> list = Stream.of("one", "two").map(x -> x.toUpperCase()).collect(Collectors.toList());
		
		String string = Stream.of("one", "two").peek(x -> x.toUpperCase()).findFirst().get();
		
		
//		System.out.println(list);
		System.out.println(string);
	}
	
	private static void accumulator() {
		
//		int accumulator = 2;
//		for(int element : new int[] {1, 2, 3}) {
//			accumulator += element;
//		}
//		System.out.println(accumulator);

//		BinaryOperator<Integer> accumulator = (acc, element) -> acc * element;
//		int count2 = accumulator.apply(
//						accumulator.apply(
//								accumulator.apply(1, 1), 
//						2), 
//					7);
//		System.out.println(count2);
		
		int count = Stream.of(1, 2, 4, 0).reduce(2, (accumulator, element) -> accumulator + element);
		System.out.println(count);
		
	}
	
	private static void old() {
		
		List<String> list = new ArrayList<>();
		list.add("11");
		list.add("22");
		list.add("33");
		for (String s : list) {
			System.out.println(s);
		}
		
		System.out.println();
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
