package ch5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DST {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("US/Eastern");
        LocalDate date1 = LocalDate.of(2016, 3, 13);
        LocalDate date2 = LocalDate.of(2016, 11, 6);
        LocalTime time = LocalTime.of(2, 15);
        ZonedDateTime spring = ZonedDateTime.of(date1, time, zone);
        ZonedDateTime fall = ZonedDateTime.of(date2, time, zone);
        System.out.println("Spring: " + spring.toString());
        System.out.println("Fall: " + fall.toString());
    }

}

