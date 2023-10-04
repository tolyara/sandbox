package interview.multithreading;

import interview.livecoding.fortest.TestUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * https://www.baeldung.com/java-completablefuture
 *
 * https://www.callicoder.com/java-8-completablefuture-tutorial/
 *
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        doAsSimpleFuture();
//        doThenRun();
        doThenCompose();
    }

    private static void doAsSimpleFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        String result = completableFuture.get();
        TestUtil.printTestResult("Hello", result);
    }

    private static void doThenRun() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
            System.out.println("Computation started.");
            sleepForAwhile();
            return "Hello";
        });

        CompletableFuture<Void> future = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));

        future.get();
    }

    private static void doThenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
                    sleepForAwhile();
                    return "Hello";
                })
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        TestUtil.printTestResult("Hello World", completableFuture.get());
    }

    private static void sleepForAwhile() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
