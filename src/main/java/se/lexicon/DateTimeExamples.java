package se.lexicon;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeExamples {

    public static void main(String[] args) {
        ex8();
    }

    public static void ex1() {
        // Crating a LocalDate with current date
        LocalDate today = LocalDate.now();
        System.out.println("current date: " + today);

        LocalDate nextBirthDay = LocalDate.parse("2021-02-27"); // yyyy-MM-dd
        System.out.println("nextBirthDay = " + nextBirthDay);

        LocalDate nextDay = LocalDate.of(2021, 1, 26);
        System.out.println("nextDay = " + nextDay);

        // LocalDate is a mutable object
        LocalDate myBirthDate = nextBirthDay.minusYears(31);
        System.out.println("myBirthDate = " + myBirthDate);

    }

    public static void ex2() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("currentDate = " + currentDate);

        Month january = currentDate.getMonth();
        System.out.println("january = " + january);

        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        System.out.println("DayOfWeek = " + dayOfWeek);
    }

    public static void ex3() {
        // Creating LocalTime
        LocalTime currentTime = LocalTime.now(); // HH:mm:ss
        System.out.println("currentTime = " + currentTime);

        System.out.println(currentTime.truncatedTo(ChronoUnit.MINUTES));
        System.out.println(currentTime.truncatedTo(ChronoUnit.SECONDS));

        LocalTime lunchTime = LocalTime.of(12, 0);
        System.out.println("lunchTime = " + lunchTime);

        LocalTime lunchTime2 = LocalTime.parse("12:00");
        System.out.println("lunchTime = " + lunchTime2);

        //LocalTime testTime = LocalTime.parse("12:0"); // DateTimeParseException
        //System.out.println("testTime = " + testTime);

    }

    public static void ex4() {
        LocalTime localTime = LocalTime.parse("23:59").plusHours(1).plusMinutes(30).minusSeconds(50);
        System.out.println("localTime = " + localTime);

        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        System.out.println(hour + " : " + minute + " : " + second);

        System.out.println(LocalTime.MIN); // 00:00
        System.out.println(LocalTime.MAX); // 23:59:59:999999999
    }

    public static void ex5() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("currentDateTime = " + currentDateTime);

        LocalDateTime plushHour = currentDateTime.plusHours(1);
        System.out.println("plushHour = " + plushHour);

    }

    public static void ex6() {
        LocalDate march25 = LocalDate.parse("2020-03-25");

        String basicISODateString = march25.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("basicISODateString = " + basicISODateString);

        String isoDateString = march25.format(DateTimeFormatter.ISO_DATE); // 2020-03-25
        System.out.println("isoDateString = " + isoDateString);

        String custom = march25.format(DateTimeFormatter.ofPattern("eeee dd MM YYYY"));
        System.out.println("custom = " + custom);
    }

    // Period: measure the quantity of time in terms of year,month and day
    public static void ex7() {

        LocalDate originalMeetingDate = LocalDate.parse("2020-12-07");
        System.out.println("originalMeetingDate = " + originalMeetingDate);
        Period pM= Period.ofMonths(2);
        Period pD= Period.ofDays(2);
        LocalDate postponeMeetingDate = originalMeetingDate.plus(pM).plus(pD);
        System.out.println("postponeMeetingDate = " + postponeMeetingDate);


        LocalDate myBirthDate = LocalDate.parse("1989-02-27");
        LocalDate today = LocalDate.now();

        // Period can calculate years, months, days between two dates
        Period period= Period.between(myBirthDate,today);

        int years = period.getYears();
        int months= period.getMonths();
        int days = period.getDays();
        System.out.println("years = " + years);
        System.out.println("months = " + months);
        System.out.println("days = " + days);

    }

    public static void ex8(){
        // Duration:  we can measure the quantity of time in terms of second
        LocalTime start = LocalTime.MIDNIGHT;
        LocalTime now = LocalTime.now();
        Duration durationSinceStart= Duration.between(start,now);
        System.out.println("durationSinceStart.getSeconds() = " + durationSinceStart.getSeconds());

        // in JDK 8 Duration Class = just can measure the quantity of second between two times

    }
}
