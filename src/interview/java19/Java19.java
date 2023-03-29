package interview.java19;

import java.util.concurrent.*;

public class Java19 {

    record Point(int x, int y) {};

    private static final int iterations = 100_000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        JEP_405_Record_Patterns();
//        JEP_425_Virtual_Threads();
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
//        ExecutorService executorService = Executors.newCachedThreadPool();

        // new, 2 kb and lightweight stack
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        Runnable task = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("Thread done. ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < iterations; i++) {
            Future<?> result = executorService.submit(task);
            result.get();

//            executorService.submit(task);
        }

    }

}
