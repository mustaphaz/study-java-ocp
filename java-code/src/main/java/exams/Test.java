package exams;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {

    public static void calculate(List<Integer> ls) {
//        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b)); //1
//        System.out.println(ls.stream().max(Integer::max).get()); //2
        System.out.println(ls.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                Integer result = Integer.compare(a, b);
                return result;
            }
        })); //3
/*        System.out.println(ls.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                Integer result = a > b ? a : b;
                return result;
            }
        })); */
    }

    private static void periodDuration() {
        LocalDate today = LocalDate.of(2015, Month.SEPTEMBER, 2);
        LocalTime time = LocalTime.of(1, 0, 0);
        LocalDateTime now = LocalDateTime.of(today, time);

        Period p = Period.between(today, LocalDate.of(2015, Month.SEPTEMBER, 1));
        System.out.println(p);
        Duration d = Duration.between(now, LocalDateTime.of(2015, Month.SEPTEMBER, 2, 10, 10));
        System.out.println(d);
    }

    private static void parralelStreamTest() {
        String join = Arrays.asList("a", "b").parallelStream().reduce("_", (String::concat));
        System.out.println(join);
    }

    private static void durationBetween() {
        // Given that New York is 3 hours ahead of Los Angeles, what will the following code print?
        LocalDateTime ldt = LocalDateTime.of(2017, 12, 02, 10, 0, 0);
        ZonedDateTime nyZdt = ldt.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime laZdt = ldt.atZone(ZoneId.of("America/Los_Angeles"));
        Duration d = nyZdt.isBefore(laZdt) ? Duration.between(laZdt, nyZdt) : Duration.between(nyZdt, laZdt);

        System.out.println(nyZdt.isBefore(laZdt));
        System.out.println(laZdt.isBefore(nyZdt));
        System.out.println("nyZdt: " + nyZdt);
        System.out.println("laZdt: " + laZdt);
        System.out.println(d);
    }

    private static void checkEven() {

        List<Integer> values = Arrays.asList(2, 4, 6, 9); //1

        Predicate<Integer> check = (Integer i) -> {
            System.out.println("Checking");
            return i == 4; //2
        };

//        Predicate even = (Integer i) -> i % 2 == 0;  //3
//        values.stream().filter(check).filter(even).count(); //4
    }

    public static void checkAssertions() {
        boolean enabled = false;
        assert enabled = true;
        if (!enabled) throw new RuntimeException("Assertions should be enabled");
    }

    private static void testStream() {

        String sentence1 = "Carpe diem. Seize the day, boys. Make your lives extraordinary.";
        String sentence2 = "Frankly, my dear, I don't give a damn!";
        String sentence3 = "Do I look like I give a damn?";
        List<String> sentences = Arrays.asList(sentence1, sentence2, sentence3);

        Stream<String> strm = sentences.stream()
                .flatMap(str -> Stream.of(str.split("[ ,.!?\r\n]")))
                .filter(s -> s.length() > 0)
                .distinct();
        strm.forEach(System.out::println);

    }

    private static void testStreamString() {

        String name = "bob";
        String val = null;
        Supplier<String> s = name::toUpperCase;
        val = s.get();

        System.out.print(val);

    }

    private static void testRelativize() {

        Path p1 = Paths.get("/personal/./photos/../readme.txt");
        Path p2 = Paths.get("/personal/index.html");
        Path p3 = p1.relativize(p2);
        Path p4 = (p1.normalize()).relativize(p2);
        System.out.println("p3:" + p3);
        System.out.println("p4:" + p4);
    }

    public static void main(String[] args) {
        testRelativize();
    }
}
