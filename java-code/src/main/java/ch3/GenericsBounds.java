package ch3;

import java.util.ArrayList;
import java.util.List;

public class GenericsBounds {
    public static void printList(List<Object> list) {
        for (Object x : list) System.out.println(x);
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
//        printList(keywords); // DOES NOT COMPILE
    }
}
