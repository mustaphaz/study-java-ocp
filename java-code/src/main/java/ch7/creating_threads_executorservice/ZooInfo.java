package ch7.creating_threads_executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            System.out.println("begin" + " ==> on thread: " + Thread.currentThread().getName());
            service.execute(() -> System.out.println("Printing zoo inventory" + " ==> on thread: " + Thread.currentThread().getName()));
            service.execute(() -> {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("Printing record: " + i + " ==> on thread: " + Thread.currentThread().getName());
                        }
                    }
            );

            service.execute(() -> System.out.println("Printing zoo inventory" + " ==> on thread: " + Thread.currentThread().getName()));

            System.out.println("end" + " ==> on thread: " + Thread.currentThread().getName());
        } finally {
            if (service != null) service.shutdown();
        }
    }
}