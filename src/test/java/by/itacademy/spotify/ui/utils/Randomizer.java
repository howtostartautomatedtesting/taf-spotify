package by.itacademy.spotify.ui.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {
    public static String generateText() {
        int lowerLimit = 8;
        int upperLimit = 13;
        return RandomStringUtils.randomAlphabetic(lowerLimit, upperLimit);
    }
    public static String getForbiddenCharacter() {
        List<String> forbiddenCharacters = new ArrayList<>();
        forbiddenCharacters.add("'");
        forbiddenCharacters.add("`");
        forbiddenCharacters.add("&");
        forbiddenCharacters.add(":");
        int randomIndex = new java.util.Random().nextInt(forbiddenCharacters.size());
        return forbiddenCharacters.get(randomIndex);
    }
}
