package ch3;

import java.util.ArrayList;
import java.util.List;

/*  The main() method calls printDragons() with a raw type. Due to type erasure, Java doesn’t know this is a problem
    until runtime, when it attempts to cast a Unicorn to a Dragon. The cast is tricky because it
    doesn’t appear in the code.     */

class Dragon {
}

class Unicorn {
}

public class LegacyDragons {
    public static void main(String[] args) {
        List unicorns = new ArrayList();
        unicorns.add(new Unicorn());
        printDragons(unicorns);
    }

    private static void printDragons(List<Dragon> dragons) {
        for (Dragon dragon : dragons) { // ClassCastException
            System.out.println(dragon);
        }
    }
}
