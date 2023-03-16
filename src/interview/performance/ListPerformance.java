package interview.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 *      Summary results:                        LinkedList  |   ArrayList
 *      removing  (begin, middle, end)           +  -  +=        -  +  -=
 *      insertion (begin, middle, end)           +  -  -=        -  +  +=
 *      getting   (begin, middle, end)           =  -   =        =  +   =
 */
public class ListPerformance {

//    private static final int iterations = 2_000_000;
//    private static final int iterations = 200_000;
    private static final int iterations = 20_000;

    private static final String str = "Hello";

    private static final UnaryOperator<List<String>> listFiller = (list) -> {
        for (int i = 0; i < iterations; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    };

    public static void main(String[] args) {
//        testListsInsertToBegin();
//        testListsInsertToMiddle();
//        testListsInsertToEnd();

//        testListsRemoveFromBegin();
//        testListsRemoveFromMiddle();
//        testListsRemoveFromEnd();

//        testListsGetFirstElement();
        testListsGetMiddleElement();
//        testListsGetLastElement();
    }

    /*
        LinkedList wins
    */
    private static void testListsRemoveFromBegin() {
        // iterations - 20_000
        // linked : 8   5   3
        // array  : 46  48  49

        Consumer<List<String>> removerFromBegin = (list) -> {
            while (!list.isEmpty()) {
                list.remove(0);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), listFiller, removerFromBegin);
    }

    /*
        ArrayList wins
    */
    private static void testListsRemoveFromMiddle() {
        // iterations - 20_000
        // linked : 363 334 349
        // array  : 26  25  27

        // iterations - 20_000
        // linked : 105788
        // array  : 2512
        Consumer<List<String>> removerFromBegin = (list) -> {
            while (!list.isEmpty()) {
                list.remove((list.size() - 1)/2);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), listFiller, removerFromBegin);
    }

    /*
        LinkedList has a little advantage
     */
    private static void testListsRemoveFromEnd() {
        // iterations - 20_000
        // linked : 4   8   3
        // array  : 3   2   3

        // iterations - 200_000
        // linked : 12   16   13
        // array  : 24   24   22

        Consumer<List<String>> removerFromEnd = (list) -> {
            while (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), listFiller, removerFromEnd);
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

        Consumer<List<String>> inserterToBegin = (list) -> {
            for (int i = 0; i < iterations; i++) {
                list.add(0, str);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), list -> list, inserterToBegin);
    }

    /*
        ArrayList wins
    */
    private static void testListsInsertToMiddle() {
        // iterations - 20_000
        // linked : 203 200 196
        // array  : 26  25  26

        // iterations - 200_000
        // linked : 19713   19940
        // array  : 2426    2407

        Consumer<List<String>> inserterToMiddle = (list) -> {
            for (int i = 0; i < iterations; i++) {
                list.add((list.size() - 1)/2, str);
//                list.add((list.size() - 1)/2, str + i);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), list -> list, inserterToMiddle);
    }

    /*
        ArrayList has a little advantage
    */
    private static void testListsInsertToEnd() {
        // iterations - 2_000_000
        // linked : 99 107 119 etc.
        //  array : 83 90  85

        Consumer<List<String>> inserterToEnd = (list) -> {
            for (int i = 0; i < iterations; i++) {
                list.add(str);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), list -> list, inserterToEnd);
    }

    /*
        Parity
    */
    private static void testListsGetFirstElement() {
        // iterations - 2_000_000
        // linked : 5   4   5
        //  array : 5   6   5
        Consumer<List<String>> firstElementGetter = (list) -> {
            for (int i = 0; i < iterations; i++) {
                list.get(0);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), listFiller, firstElementGetter);
    }

    /*
        Parity
    */
    private static void testListsGetLastElement() {
        // iterations - 2_000_000
        // linked : 8   8   8
        //  array : 5   6   6

        Consumer<List<String>> lastElementGetter = (list) -> {
            for (int i = 0; i < iterations; i++) {
                list.get(list.size() - 1);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), listFiller, lastElementGetter);
    }

    /*
        ArrayList wins
    */
    private static void testListsGetMiddleElement() {
        // iterations - 20_000
        // linked : 272 309 283
        //  array : 2   1   1

        Consumer<List<String>> middleElementGetter = (list) -> {
            for (int i = 0; i < iterations; i++) {
                list.get(i);
            }
        };
        testLists(new LinkedList<>(), new ArrayList<>(), listFiller, middleElementGetter);
    }

    private static void testLists(List<String> linkedList, List<String> arrayList,
                                  UnaryOperator<List<String>> listFiller, Consumer<List<String>> targetOperation) {
        System.out.println("Preparations are being made ... ");
        linkedList = listFiller.apply(linkedList);
        arrayList = listFiller.apply(arrayList);
        System.out.println("Performance benchmarking starts ... ");
        process(linkedList, "linked", targetOperation);
        process(arrayList, "array", targetOperation);
    }

    private static void process(List<String> list, String listName, Consumer<List<String>> consumer) {
        long start = System.currentTimeMillis();
        consumer.accept(list);
        long finish = System.currentTimeMillis();
        System.out.println(listName + " : " + (finish - start));
    }

}
