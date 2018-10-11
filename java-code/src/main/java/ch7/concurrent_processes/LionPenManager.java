package ch7.concurrent_processes;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {
    private void removeAnimals() {
        System.out.printf("Removing animals\t %s.%n", Thread.currentThread().getName());
    }

    private void cleanPen() {
        System.out.printf("Cleaning the pen\t %s.%n", Thread.currentThread().getName());
    }

    private void addAnimals() {
        System.out.printf("Adding animals\t\t %s.%n", Thread.currentThread().getName());
    }

    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();

            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle checked exceptions here
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                    () -> System.out.println("*** Pen Cleaned!"));
            for (int i = 0; i < 4; i++)
//                service.submit(() -> manager.performTask());
                service.submit(() -> manager.performTask(c1, c2));
        } finally {
            if (service != null) service.shutdown();
        }
    }
}