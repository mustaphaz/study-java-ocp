package exams;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TestNavigableSet {


    public static void main(String[] args) {
        NavigableSet<String> mySet = new TreeSet<>();
        mySet.add("a");
        mySet.add("b");
        mySet.add("c");
        mySet.add("aa");
        mySet.add("bb");
        mySet.add("cc");
        System.out.println(mySet.floor("a"));
        System.out.println(mySet.ceiling("aaa"));
        System.out.println(mySet.lower("a"));
        System.out.println(mySet.higher("bb"));
    }
}
