package ua.in.sydoruk;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class GreetingToWorldTest {
    final static Logger logger = Logger.getLogger(GreetingToWorldTest.class);

    private Locale localeRu = new Locale("ru", "RU");
    private Locale localeUs = new Locale("en", "US");


    private LocalTime time6 = LocalTime.of(6, 30);
    private LocalTime time9 = LocalTime.of(9, 30);
    private LocalTime time19 = LocalTime.of(19, 30);
    private LocalTime time23 = LocalTime.of(23, 30);

    @Test
    public void testLocaleUS() throws IOException {
         String greetingMorningEn = "Good morning, World!";
         String greetingDayEn = "Good day, World!";
         String greetingEveningEn = "Good evening, World!";
         String greetingNightEn = "Good night, World!";
        Locale.setDefault(localeUs);
        try {
            testTime(greetingMorningEn, greetingDayEn, greetingEveningEn, greetingNightEn);
        } catch (IOException e) {
            logger.error(e);
        }

    }


    @Test
    public void testLocaleRu() {
        String greetingMorningRu = "Доброе утро, Мир!";
        String greetingDayRu = "Добрый день, Мир!";
        String greetingEveningRu = "Добрый вечер, Мир!";
        String greetingNightRu = "Доброй ночи, Мир!";
        Locale.setDefault(localeRu);
        try {
            testTime(greetingMorningRu, greetingDayRu, greetingEveningRu, greetingNightRu);
        } catch (IOException e) {
            logger.error(e);
        }

    }

    private void testTime(String greetingMorning, String greetingDay,
                          String greetingEvening, String greetingNight) throws IOException {

        ByteArrayOutputStream outContentForMorning = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForMorning));
        GreetingToWorld.getMessage(time6);
        assertEquals(greetingMorning, outContentForMorning.toString());
        outContentForMorning.close();

        ByteArrayOutputStream outContentForDay = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForDay));
        GreetingToWorld.getMessage(time9);
        assertEquals(greetingDay, outContentForDay.toString());
        outContentForDay.close();

        ByteArrayOutputStream outContentForEvening = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForEvening));
        GreetingToWorld.getMessage(time19);
        assertEquals(greetingEvening, outContentForEvening.toString());
        outContentForEvening.close();

        ByteArrayOutputStream outContentForNight = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentForNight));
        GreetingToWorld.getMessage(time23);
        assertEquals(greetingNight, outContentForNight.toString());
        outContentForNight.close();
    }


}
