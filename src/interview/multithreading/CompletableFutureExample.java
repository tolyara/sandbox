package interview.multithreading;

import interview.livecoding.fortest.TestUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAsSimpleFuture();
    }

    public static Future<String> doAsSimpleFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        String result = completableFuture.get();
        TestUtil.printTestResult("Hello", result);

        return completableFuture;
    }

}
