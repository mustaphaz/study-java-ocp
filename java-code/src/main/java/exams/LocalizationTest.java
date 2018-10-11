package exams;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationTest {

    public static void main(String[] args) {
        Locale myloc = new Locale.Builder().setLanguage("en").setRegion("UK").build(); //L1
        ResourceBundle msgs = ResourceBundle.getBundle("mymsgs", myloc);
        Enumeration<String> en = msgs.getKeys();
        msgs.keySet().forEach(System.out::println);

        while (en.hasMoreElements()) {
            String key = en.nextElement();
            String val = msgs.getString(key);
            System.out.println(key + " : " + val);
        }
    }
}
