package by.itacademy.spotify.ui.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {
    public static String generateText() {
        int lowerLimit = 8;
        int upperLimit = 13;
        return RandomStringUtils.randomPrint(lowerLimit, upperLimit);
    }
}
