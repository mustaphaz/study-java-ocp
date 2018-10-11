package ch7.creating_a_thread;

//    Defining the task, or work, that a Thread instance will execute by
//    providing a Runnable object or lambda expression to the Thread constructor.

public class PrintData implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println("Printing record: " + i);
    }

    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }
}

