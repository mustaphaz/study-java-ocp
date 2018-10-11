package ch7.parallel_streams;

import java.util.ArrayList;
import java.util.List;

public class WhaleDataCalculator {
    public int processRecord(int input) {
        try {
            System.out.printf("Thread: %s goes to sleep at %d.%n", Thread.currentThread().getName(), System.currentTimeMillis());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // Handle interrupted exception
        }
        System.out.printf("Thread: %s is active again at %d.%n", Thread.currentThread().getName(), System.currentTimeMillis());
        return input + 1;
    }

    public void processAllData(List<Integer> data) {
        data.stream().map(a -> processRecord(a)).count();
    }

    public void processAllDataParellel(List<Integer> data) {
        data.parallelStream().map(a -> processRecord(a)).count();
    }

    public static void main(String[] args) {
        WhaleDataCalculator calculator = new WhaleDataCalculator();

        // Define the data
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 4000; i++) data.add(i);

        // Process the data
        long start = System.currentTimeMillis();
        calculator.processAllData(data);
//        calculator.processAllDataParellel(data);
        double time = (System.currentTimeMillis() - start)/1000.0;

        // Report results
        System.out.println("\nTasks completed in: " + time + " seconds");
    }
}