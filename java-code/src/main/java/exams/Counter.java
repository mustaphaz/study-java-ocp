package exams;

public class Counter implements Runnable {
    private int count;

    @Override
    public void run() {
        increment();
    }

    private void increment() {
        String threadName = Thread.currentThread().getName();
        Long timestamp = System.currentTimeMillis();
        System.out.println(count++ + " increment in: " + threadName + " at time: " + timestamp);
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter);
        thread1.setName("thread1");
        Thread thread2 = new Thread(counter);
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }

}