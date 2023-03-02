package interview.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsPerformance {

    private static final int iterations = 2_000_000;
    private static final String str = "Hello";

    public static void main(String[] args) {
        testLists();
    }

    private static void testLists() {
        // linked : 99 107 119 etc.
        //  array : 83 90  85

        long start = System.currentTimeMillis();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            linkedList.add(str);
        }
        long finish = System.currentTimeMillis();
        System.out.println("linked : " + (finish - start));

        start = System.currentTimeMillis();
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(str);
        }
        finish = System.currentTimeMillis();
        System.out.println("array : " + (finish - start));
    }

}
