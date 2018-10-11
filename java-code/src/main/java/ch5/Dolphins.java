package ch5;

import java.util.Locale;
import java.util.ResourceBundle;

public class Dolphins {
    public static void main(String[] args) {
        Locale fr = new Locale("fr");
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle b = ResourceBundle.getBundle("Dolphins");
        System.out.println("name: " + b.getString("name"));
        System.out.println("age: " + b.getString("age"));
    }
}
