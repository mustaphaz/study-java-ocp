package exams;


class Threader extends Thread {
    public void run() {
        System.out.println("In Threader");
    }
}

class Pooler extends Thread {
    public Pooler() {
    }

    public Pooler(Runnable r) {
        super(r);  //1
    }

    public void run() {
        System.out.println("In Pooler");
    }
}

public class TestClassThreader {
    public static void main(String[] args) {
        Threader t = new Threader();
        Thread h = new Pooler(t);  //2
        h.start(); //3
    }
}
