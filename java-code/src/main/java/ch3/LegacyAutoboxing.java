package ch3;

/*  Java doesn’t know that the list contains an Integer. It just knows
    that we have an Object. And an Object can’t be unboxed into an int. */

public class LegacyAutoboxing {
    public static void main(String[] args) {
        java.util.List numbers = new java.util.ArrayList();
        numbers.add(5);
//        int result = numbers.get(0); // DOES NOT COMPILE
    }
}