package interview.livecoding.javarush;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicate {

    public static void main(String[] args) {
        List<Integer> elements = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        elements.set(53, 23);
//        findDuplicate(elements);

        List<Integer> elements2 = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        elements2.set(50, 20);
        elements2.set(51, 21);
        elements2.set(52, 37);
        findDuplicates(elements2);
    }

    // will work for case when array has one and only one duplicate element
    private static void findDuplicate(List<Integer> elements) {
        int distinctSum = elements.stream().distinct().mapToInt(e -> e).sum();
        int totalSum = elements.stream().mapToInt(e -> e).sum();
        System.out.println("Element that repeats : " + (totalSum - distinctSum));
    }

    private static void findDuplicates(List<Integer> elements) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer element : elements) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }
        List<Integer> duplicates = map.entrySet().stream().filter(entry -> (entry.getValue() > 1))
                .map(entry -> entry.getKey()).collect(Collectors.toList());
        System.out.println(duplicates);
    }

}
