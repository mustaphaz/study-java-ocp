package ch7.review_questions;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void question7() {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
        Set<Integer> s3 = new ConcurrentSkipListSet<>();
        s3.addAll(l1);

        for (Integer item : l2) {
            l2.add(4);
            System.out.println("l2 size: " + l2.size()); // x1
        }
        for (Integer item : s3) {
            s3.add(5); // x2
            System.out.println("l3 size: " + s3.size());
        }
        System.out.println(l1.size() + " " + l2.size() + " " + s3.size());
    }

//    static void question10(){
//        System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
//                .parallelStream().parallel() // q1
//                .reduce(0,
//                        (ch1, c2) -> ch1.length() + c2.length(), // q2
//                        (s1, s2) -> s1 + s2)); // q3
//    }

    public static void main(String[] args) {
        question7();
    }
}
