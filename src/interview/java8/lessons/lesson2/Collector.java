package interview.java8.lessons.lesson2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector {
	
	public static void main(String[] args) {
//		Stream.of("one", "two").collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);
//		Stream.of("three", "four").collect(Collectors.toCollection(TreeSet::new)).forEach(x -> System.out.println(x.toUpperCase()));
		
//		Stream.of(12, 23, 1).collect(Collectors.maxBy(Comparator.comparing(x -> x))).stream().forEach(System.out::println);
//		System.out.println(Stream.of("5", "15", "4").collect(Collectors.averagingInt(x -> Integer.valueOf(x))));
		
//		Map<Boolean, List<Integer>> map = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(x -> x > 2));
//		Set<Entry<Boolean, List<Integer>>> entrySet = map.entrySet();
//		entrySet.stream().forEach(System.out::println);
		
//		Map<Integer, List<Integer>> map2 = Stream.of(1, 2, 1, 4).collect(Collectors.groupingBy(x -> -x));
//		map2.entrySet().stream().forEach(System.out::println);
		
//		String result = Stream.of("one", "two", "three").collect(Collectors.joining(", ", "{", "}"));
//		System.out.println(result);
		
		Map<Integer, Long> map3 = Stream.of(1, 2, 1, 4, 1, 5, 2).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(map3.get(2));
	}

}
