package ch7.creating_threads_executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 500; i++) CheckResults.counter++;
            });
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached!" + " ==> on thread: " + Thread.currentThread().getName());
        } catch (TimeoutException e) {
            System.out.println("Not reached in time" + " ==> on thread: " + Thread.currentThread().getName());
        } finally {
            if (service != null) service.shutdown();
        }
    }
}