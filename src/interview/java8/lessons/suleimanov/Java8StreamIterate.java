package interview.java8.lessons.suleimanov;

import java.util.Arrays;
import java.util.stream.Stream;

public class Java8StreamIterate {

    public static void main(String[] args) {

        Stream.iterate(1, n -> n < 40, n -> n * 2)
                .forEach(System.out::println);

//        Stream.iterate(new Integer[]{0, 1}, n -> new Integer[]{n[1], n[0] + n[1]})
//                .limit(10)
//                .forEach(array -> System.out.println(Arrays.deepToString(array)));

//        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
//                .limit(10)
//                .map(n -> n[0])
//                .forEach(System.out::println);

//        int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
//                .limit(10)
//                .map(n -> n[0]) // Stream<Integer>
//                .mapToInt(n -> n)
//                .sum();
//        System.out.println("Fibonacci 10 sum : " + sum);

//        Stream.iterate(0, n -> n + 1)
//                .filter(x -> x % 2 != 0) // odd
//                .limit(10)
//                .forEach(System.out::println);

    }

}
