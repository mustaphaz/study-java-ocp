package ch1;

public class Outer {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        // ugly
        Outer outer1 = new Outer();
        Inner inner1 = outer1.new Inner(); // create the inner class
        inner1.go();

        // even uglier
        Outer outer2 = new Outer();
        Inner inner2 = new Outer().new Inner(); // create the inner class 2.0
        inner2.go();
        outer2.callInner();
    }
}