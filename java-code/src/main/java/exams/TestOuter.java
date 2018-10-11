package exams;


public class TestOuter {
    public void myOuterMethod() {
        this.new TestInner();
        new TestOuter().new TestInner();
    }

    public class TestInner {
    }

    public static void main(String[] args) {
        TestOuter to = new TestOuter();
        to.new TestInner();
    }
}
