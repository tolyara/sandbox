package interview.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TryCatchPerformance {

    private static final int iterations = 7_000_000;

    public static void main(String[] args) {
        // iterations - 7_000_000
        // simple       : 3751    3363    3568    3536
        // try-catch    : 5899    5807    3601    5973

        List<String> list1 = new ArrayList<>();
        Consumer<List<String>> simple = (list) -> {
            for (int i = 0; i < iterations; i++) {
                list.add(String.valueOf(i));
            }
        };
        long start = System.currentTimeMillis();
        simple.accept(list1);
        long finish = System.currentTimeMillis();
        System.out.println("simple" + " : " + (finish - start));

        List<String> list2 = new ArrayList<>();
        Consumer<List<String>> tryCatch = (list) -> {
            try {
                simple.accept(list);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        };
        start = System.currentTimeMillis();
        tryCatch.accept(list2);
        finish = System.currentTimeMillis();
        System.out.println("try-catch" + " : " + (finish - start));
    }

}
