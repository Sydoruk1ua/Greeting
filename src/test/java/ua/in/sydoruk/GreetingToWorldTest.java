package ua.in.sydoruk;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Clock;
import java.time.Instant;
import java.util.Locale;

import static java.time.ZoneOffset.UTC;
import static org.junit.Assert.assertEquals;

public class GreetingToWorldTest {
    final static Logger logger = Logger.getLogger(GreetingToWorldTest.class);

    @Test
    public void testLocaleUS() throws IOException {
        String greetingMorningEn = "Good morning, World!";
        String greetingDayEn = "Good day, World!";
        String greetingEveningEn = "Good evening, World!";
        String greetingNightEn = "Good night, World!";
        Locale.setDefault(new Locale("en", "US"));

        testTime(greetingMorningEn, greetingDayEn, greetingEveningEn, greetingNightEn);


    }


    @Test
    public void testLocaleRu() {
        String greetingMorningRu = "Доброе утро, Мир!";
        String greetingDayRu = "Добрый день, Мир!";
        String greetingEveningRu = "Добрый вечер, Мир!";
        String greetingNightRu = "Доброй ночи, Мир!";
        Locale.setDefault(new Locale("ru", "RU"));

        testTime(greetingMorningRu, greetingDayRu, greetingEveningRu, greetingNightRu);


    }

    private void testTime(String greetingMorning, String greetingDay,
                          String greetingEvening, String greetingNight) {

        assertEquals(greetingMorning, getGreetingFromOutputStream("2007-12-03T06:00:00.00Z"));
        assertEquals(greetingDay, getGreetingFromOutputStream("2007-12-03T09:00:00.00Z"));
        assertEquals(greetingEvening, getGreetingFromOutputStream("2007-12-03T19:00:00.00Z"));
        assertEquals(greetingNight, getGreetingFromOutputStream("2007-12-03T23:00:00.00Z"));
    }

    private String getGreetingFromOutputStream(String currentTestTime) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new GreetingToWorld(Clock.fixed(Instant.parse(currentTestTime), UTC)).displayGreeting();
        try {
            outContent.close();
        } catch (IOException e) {
            logger.error(e);
        }

        return outContent.toString();

    }


}
