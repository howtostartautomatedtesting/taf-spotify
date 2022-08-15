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
        System.out.println(randomIndex);
        System.out.println(forbiddenCharacters.get(randomIndex));
        return forbiddenCharacters.get(randomIndex);
    }
}