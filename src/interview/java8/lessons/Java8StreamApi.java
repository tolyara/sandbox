package interview.java8.lessons;

import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamApi {

    public static void main(String[] args) {
        final Collection<Integer> list = Arrays.asList(3, 8, 1, 5, 9, 12, 81);

//        Collection<Integer> result = sorted(list);
//        Integer result = reduce(list);
        Integer result = methodChaining(list);

        System.out.println(result);
    }

    private static <E> Collection<E> sorted(Collection<E> collection) {
//        return collection.stream().sorted().collect(Collectors.toList());
        return collection.stream().sorted(Comparator.comparing(e -> e.hashCode())).collect(Collectors.toList()); // [1, 3, 5, 8, 9, 12, 81]
//        return collection.stream().sorted(Comparator.comparing(e -> e.toString())).collect(Collectors.toList()); // [1, 12, 3, 5, 8, 81, 9]
    }

    private static Integer reduce(Collection<Integer> collection) {
        return collection.stream().reduce((accumulator, element) -> accumulator * element).get(); // 1049760
    }

    private static Integer methodChaining(Collection<Integer> collection) {
        return collection.stream().filter(e -> (e % 2) == 1).reduce((a, e) -> a + e).get();
    }

}
