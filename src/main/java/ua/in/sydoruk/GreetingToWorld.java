package ua.in.sydoruk;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

class GreetingToWorld {
    final static Logger logger=Logger.getLogger(GreetingToWorld.class);
    private static LocalTime currentTime;

    static void getMessage() {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", currentLocale);

        int currentHour = getCurrentTime().getHour();
        String greeting = null;
        if (currentHour >= 6 && currentHour < 9) {
            greeting = resourceBundle.getString("greetingMorning");
        } else if (currentHour >= 9 && currentHour < 19) {
            greeting = resourceBundle.getString("greetingDay");
        } else if (currentHour >= 19 && currentHour < 23) {
            greeting = resourceBundle.getString("greetingEvening");
        } else {
            greeting = resourceBundle.getString("greetingNight");
        }


        try {
            System.out.print(new String(greeting.getBytes("ISO-8859-1"), StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }

    }

     static LocalTime getCurrentTime() {
        return currentTime;
    }

     static void setCurrentTime(LocalTime localTime) {
        currentTime = localTime;
    }


}
