package interview.performance;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 *      Summary results:              HashSet   |   TreeSet
 *      removing                          +            -
 *      insertion                         +=           -=
 */
public class SetPerformance {

    private static final int iterations = 2_000_000;
//    private static final int iterations = 200_000;
//    private static final int iterations = 20_000;

    private static final String str = "Hello";

    private static final UnaryOperator<Set<String>> setFiller = (set) -> {
        for (int i = 0; i < iterations; i++) {
            set.add(String.valueOf(i));
        }
        return set;
    };

    public static void main(String[] args) {
//        testInsert();
        testRemove();
    }

    /*
        HashSet has a little advantage
    */
    private static void testInsert() {
        // iterations - 2_000_000
        // hash set :   14  15  15
        // tree set :   21  21  23

        Consumer<Set<String>> inserter = (set) -> {
            for (int i = 0; i < iterations; i++) {
                set.add(str);
            }
        };
        new PerformanceMeasurer<Set<String>>(iterations).process(Arrays.asList(new HashSet<>(), new TreeSet<>()), set -> set, inserter);
    }

    /*
        Hash Set wins
     */
    private static void testRemove() {
        // iterations - 2_000_000
        // hash set :   263     238     232
        // tree set :   465     466     450

        Consumer<Set<String>> remover = (set) -> {
            for (int i = 0; i < iterations; i++) {
                set.remove(String.valueOf(i));
            }
        };
        new PerformanceMeasurer<Set<String>>(iterations).process(Arrays.asList(new HashSet<>(), new TreeSet<>()), setFiller, remover);
    }

}
