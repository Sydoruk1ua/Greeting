package ua.in.sydoruk;

import java.time.Clock;

public class Main {
    public static void main(String[] args) {
        new GreetingToWorld(Clock.systemDefaultZone()).displayGreeting();
    }
}
