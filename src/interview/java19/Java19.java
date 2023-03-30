package interview.java19;

/*
    in Java 17 it doesn't exist yet
    java: package jdk.incubator.concurrent does not exist
 */
//import jdk.incubator.concurrent.StructuredTaskScope;

import java.util.concurrent.*;

public class Java19 {

    record Point(int x, int y) {};

    private static final int iterations = 100_000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        JEP_405_Record_Patterns();
//        JEP_425_Virtual_Threads();
        JEP_428_Structured_Concurrency();
    }

    private static void JEP_405_Record_Patterns() {
        // old
        Object point = new Point(5, 6);
        if (point instanceof Point p) {
            int x = p.x;
            int y = p.y;
            System.out.println(x + y);
        }

        // new
//        if (point instanceof Point(int xx, int yy)) {
//            System.out.println(xx + yy);
//        }
    }

    private static void JEP_425_Virtual_Threads() throws ExecutionException, InterruptedException {
        // old, 1024 kb and each stack
        ExecutorService executorService = Executors.newCachedThreadPool();

        // new, 2 kb and lightweight stack
//        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        Runnable task = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("Thread done. ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < iterations; i++) {
//            Future<?> result = executorService.submit(task);
//            result.get();

            executorService.submit(task);
        }
    }

    private static void JEP_428_Structured_Concurrency() throws InterruptedException, ExecutionException {
//        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
//            MySumCalculator sumCalculator = new MySumCalculator(4, 13);
//            Future<Integer> sumResult = scope.fork(sumCalculator);
//            MyMultipleCalculator multipleCalculator = new MyMultipleCalculator(4, 13);
//            Future<Integer> multipleResult = scope.fork(multipleCalculator);
//
//            scope.join();               // join both forks
//            scope.throwIfFailed();      // and propagate results
//
//            // here both forks are succeeded, so compose their results
//            System.out.println("sumResult = " + sumResult.resultNow() + ", multipleResult = " + multipleResult.resultNow());
//        }
    }

}

class MySumCalculator implements Callable<Integer> {

    private final Integer value1;
    private final Integer value2;

    MySumCalculator(Integer value1, Integer value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Integer call() throws InterruptedException {
        Thread.sleep(1000);
        return (value1 + value2);
    }

}

record MyMultipleCalculator(Integer value1, Integer value2) implements Callable<Integer> {

    MyMultipleCalculator(Integer value1, Integer value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Integer call() throws InterruptedException {
        Thread.sleep(1000);
        return (value1 * value2);
    }

}
