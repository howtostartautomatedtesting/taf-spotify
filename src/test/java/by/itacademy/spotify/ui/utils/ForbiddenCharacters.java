package by.itacademy.spotify.ui.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ForbiddenCharacters {
    public static String getForbiddenCharacter() {
        List<String> forbiddenCharacters = new ArrayList<>();
        forbiddenCharacters.add("'");
        forbiddenCharacters.add("`");
        forbiddenCharacters.add("&");
        forbiddenCharacters.add(":");
        int randomIndex = new Random().nextInt(forbiddenCharacters.size());
        return forbiddenCharacters.get(randomIndex);
    }
}