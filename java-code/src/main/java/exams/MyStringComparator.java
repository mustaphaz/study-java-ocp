package exams;

import java.util.*;

class MyStringComparator implements Comparator {

    private static String[]sa={"d","bbb","aaaa"};

    public int compare(Object o1, Object o2) {
        int s1 = ((String) o1).length();
        int s2 = ((String) o2).length();
        return s1 - s2;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.binarySearch(sa, "c", new MyStringComparator())
        );
        Arrays.sort(sa, new MyStringComparator());
        System.out.println(Arrays.asList(sa));
    }
}