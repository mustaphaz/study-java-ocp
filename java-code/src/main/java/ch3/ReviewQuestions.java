package ch3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class ReviewQuestions {

    public static void main(String[] args) {
        question15();
    }

    // Question 7
    private static void question7() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(new Integer(86));
        numbers.add(null);
        numbers.add(309L);
        Iterator iter = numbers.iterator();
        while (iter.hasNext())
            System.out.print(iter.next());
    }

    // Question 8
    private static void question8() {
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        System.out.println(tree.ceiling("On"));

    }

    // Question 10
    static class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return b.toLowerCase().compareTo(a.toLowerCase());
        }

        public static void main(String[] args) {
            String[] values = {"123", "Abb", "aab"};
            Arrays.sort(values, new MyComparator());
            for (String s : values)
                System.out.print(s + " ");
        }
    }

    // Question 14
    static class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
        private int num;
        private String text;

        Sorted(int n, String t) {
            this.num = n;
            this.text = t;
        }

        public String toString() {
            return "" + num;
        }

        public int compareTo(Sorted s) {
            return text.compareTo(s.text);
        }

        public int compare(Sorted s1, Sorted s2) {
            return s1.num - s2.num;
        }

        public static void main(String[] args) {
            Sorted s1 = new Sorted(88, "a");
            Sorted s2 = new Sorted(55, "b");
            TreeSet<Sorted> t1 = new TreeSet<>();
            t1.add(s1);
            t1.add(s2);
            TreeSet<Sorted> t2 = new TreeSet<>(s1);
            t2.add(s1);
            t2.add(s2);
            System.out.println(t1 + " " + t2);
        }
    }

    // Question 15
    private static void question15() {
        Comparator<Integer> c = (o1, o2) -> o2 - o1;
        List<Integer> list = Arrays.asList(5, 4, 7, 1);
        Collections.sort(list, c);
        System.out.println(Collections.binarySearch(list, 1, c));
    }

    // Question 18
    private static void question18() {
        class A {
        }
        class B extends A {
        }
        class C extends B {
        }
        class D<C> {
//            C object = new C();
        }
    }

    // Question 19
    private static void question19() {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(12);
        q.remove(1);
        System.out.print(q);

    }

}