package exams;

public class MyThread implements Runnable {
    String msg = "default";

    public MyThread(String s) {
        msg = s;
    }

    public void run() {
        System.out.println(msg + " : " + Thread.currentThread().getName());
    }

    public static void main(String args[]) {
        new Thread(new MyThread("String1")).run();
        new Thread(new MyThread("String2")).run();
        System.out.println("end : " + Thread.currentThread().getName());
    }
}

