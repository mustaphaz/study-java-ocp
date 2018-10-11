package ch3;

import java.util.ArrayList;
import java.util.List;


/*  The legacy method addUnicorn() does not actually work as advertised and adds a Dragon instead.
    Then when line 5 tries to put that Dragon in a Unicorn reference, a ClassCastException occurs.  */


public class LegacyUnicorns {
    public static void main(String[] args) {
        List<Unicorn> unicorns = new ArrayList<>();
        addUnicorn(unicorns);
        Unicorn unicorn = unicorns.get(0); // ClassCastException
    }

    private static void addUnicorn(List unicorn) {
        unicorn.add(new Dragon());
    }
}