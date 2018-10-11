package exams;

public class TestThread extends Thread {
    static int x, y;

    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            x++;
            y++;
            System.out.println(Thread.currentThread().getName()
                    + ": " + x + " " + y);
        }
    }

    public static void main(String[] args) {
        new TestThread().start();
        new TestThread().start();
    }
}


class ThreadTestClass extends Thread {
    private static int threadcounter = 0;

    public void run() {
        threadcounter++;
        System.out.println(threadcounter);
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            synchronized (TestClass.class) {
                new ThreadTestClass().start();
            }
        }
    }
}
