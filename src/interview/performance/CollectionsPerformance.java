package interview.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsPerformance {

//    private static final int iterations = 2_000_000;
    private static final int iterations = 20_000;

    private static final String str = "Hello";

    public static void main(String[] args) {
        testListsRemoveFromBegin();
    }

    /*
        LinkedList wins
    */
    private static void testListsRemoveFromBegin() {
        // iterations - 20_000
        // linked : 8   5   3
        // array  : 46  48  49

        // iterations - 200_000
        // linked :
        // array  :
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            linkedList.add(String.valueOf(i));
        }
        removeFromBegin(linkedList, "linked");

        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(String.valueOf(i));
        }
        removeFromBegin(arrayList, "array");
    }

    private static void removeFromBegin(List<String> list, String listName) {
        long start = System.currentTimeMillis();
        while (!list.isEmpty()) {
            list.remove(0);
        }
        long finish = System.currentTimeMillis();
        System.out.println(listName + " : " + (finish - start));
    }

    private static void testListsRemoveFromEnd() {

    }

    /*
        LinkedList wins
     */
    private static void testListsInsertToBegin() {
        // iterations - 20_000
        // linked : 4   3   4    etc.
        // array : 50  47  47

        // iterations - 200_000
        // linked : 9
        // array : 5258

        long start = System.currentTimeMillis();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            linkedList.add(0, str);
        }
        long finish = System.currentTimeMillis();
        System.out.println("linked : " + (finish - start));

        start = System.currentTimeMillis();
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(0, str);
        }
        finish = System.currentTimeMillis();
        System.out.println("array : " + (finish - start));
    }

    /*
        ArrayList wins
    */
    private static void testListsInsertToEnd() {
        // iterations - 2_000_000
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
