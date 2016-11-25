package ua.in.sydoruk;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class GreetingToWorldTest {
    Locale localeRu = new Locale("ru", "RU");
    Locale localeUs = new Locale("en", "US");


    LocalTime time6 = LocalTime.of(6, 30);
    LocalTime time9 = LocalTime.of(9, 30);
    LocalTime time19 = LocalTime.of(19, 30);
    LocalTime time23 = LocalTime.of(23, 30);

    String greetingMorningEn = "Good morning, World!";
    String greetingDayEn = "Good day, World!";
    String greetingEveningEn = "Good evening, World!";
    String greetingNightEn = "Good night, World!";
    String greetingMorningRu = "Доброе утро, Мир!";
    String greetingDayRu = "Добрый день, Мир!";
    String greetingEveningRu = "Добрый вечер, Мир!";
    String greetingNightRu = "Доброй ночи, Мир!";

    @Test
    public void testLocaleUS() throws IOException {
        Locale.setDefault(localeUs);

        GreetingToWorld.setCurrentTime(time6);
        ByteArrayOutputStream outContentForMorning = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForMorning));
        GreetingToWorld.getMessage();
        assertEquals(greetingMorningEn, outContentForMorning.toString());
        outContentForMorning.close();

        GreetingToWorld.setCurrentTime(time9);
        ByteArrayOutputStream outContentForDay = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForDay));
        GreetingToWorld.getMessage();
        assertEquals(greetingDayEn, outContentForDay.toString());
        outContentForDay.close();

        GreetingToWorld.setCurrentTime(time19);
        ByteArrayOutputStream outContentForEvening = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForEvening));
        GreetingToWorld.getMessage();
        assertEquals(greetingEveningEn, outContentForEvening.toString());
        outContentForEvening.close();

        GreetingToWorld.setCurrentTime(time23);
        ByteArrayOutputStream outContentForNight = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForNight));
        GreetingToWorld.getMessage();
        assertEquals(greetingNightEn, outContentForNight.toString());
        outContentForNight.close();
    }


    @Test
    public void testLocaleRu() throws IOException {
        Locale.setDefault(localeRu);

        GreetingToWorld.setCurrentTime(time6);
        ByteArrayOutputStream outContentForMorning = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForMorning));
        GreetingToWorld.getMessage();
        assertEquals(greetingMorningRu, outContentForMorning.toString());
        outContentForMorning.close();

        GreetingToWorld.setCurrentTime(time9);
        ByteArrayOutputStream outContentForDay = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForDay));
        GreetingToWorld.getMessage();
        assertEquals(greetingDayRu, outContentForDay.toString());
        outContentForDay.close();

        GreetingToWorld.setCurrentTime(time19);
        ByteArrayOutputStream outContentForEvening = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForEvening));
        GreetingToWorld.getMessage();
        assertEquals(greetingEveningRu, outContentForEvening.toString());
        outContentForEvening.close();

        GreetingToWorld.setCurrentTime(time23);
        ByteArrayOutputStream outContentForNight = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForNight));
        GreetingToWorld.getMessage();
        assertEquals(greetingNightRu, outContentForNight.toString());
        outContentForNight.close();
    }


}
