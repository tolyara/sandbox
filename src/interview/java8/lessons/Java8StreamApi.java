package interview.java8.lessons;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamApi {

    public static void main(String[] args) {
//        final Collection<Integer> list = Arrays.asList(3, 8, 1, 5, 9, 12, 81);
        final Collection<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2, 3);

//        Collection<Integer> result = sorted(list);
//        Integer result = reduce(list);
//        Integer result = methodChaining(list);
//        concat();
//        List<Integer> result = distinct(list);
        long result = count(list);

        System.out.println(result);
    }

    /* list = Arrays.asList(3, 8, 1, 5, 9, 12, 81); */
    private static <E> Collection<E> sorted(Collection<E> collection) {
//        return collection.stream().sorted().collect(Collectors.toList());
        return collection.stream().sorted(Comparator.comparing(e -> e.hashCode())).collect(Collectors.toList()); // [1, 3, 5, 8, 9, 12, 81]
//        return collection.stream().sorted(Comparator.comparing(e -> e.toString())).collect(Collectors.toList()); // [1, 12, 3, 5, 8, 81, 9]
    }

    /* list = Arrays.asList(3, 8, 1, 5, 9, 12, 81); */
    private static Integer reduce(Collection<Integer> collection) {
        return collection.stream().reduce((accumulator, element) -> accumulator * element).get(); // 1049760
    }

    private static Integer methodChaining(Collection<Integer> collection) {
        return collection.stream().filter(e -> (e % 2) == 1).reduce((a, e) -> a + e).get();
    }

    private static void concat() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> result = Stream.concat(stream1, stream2);
        result.forEach(System.out::println);
    }

    private static List<Integer> distinct(Collection<Integer> collection) {
        return collection.stream().distinct().collect(Collectors.toList());
    }

    private static long count(Collection<Integer> collection) {
//        java.lang.IllegalStateException: stream has already been operated upon or closed
//        Stream stream = collection.stream();
//        long count = stream.count();
//        return stream.distinct().count();

        return collection.stream().distinct().count();
    }

}
