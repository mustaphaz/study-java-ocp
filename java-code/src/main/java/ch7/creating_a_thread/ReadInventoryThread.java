package ch7.creating_a_thread;

//    Defining the task, or work, that a Thread instance will execute by
//    creating a class that extends Thread and overrides the run() method.

public class ReadInventoryThread extends Thread {
    @Override
    public void run() {
        System.out.println("Printing zoo inventory");
    }

    public static void main(String[] args) {
        (new ReadInventoryThread()).start();
    }
}