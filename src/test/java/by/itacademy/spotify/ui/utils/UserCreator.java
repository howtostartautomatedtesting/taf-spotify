package by.itacademy.spotify.ui.utils;

import by.itacademy.spotify.ui.entity.User;

public class UserCreator {
    public static final String USER_NAME = "itacamyspotifytest@gmail.com";
    public static final String USER_PASSWORD = "Cvbn456))";

    public static User createDefaultUser(){
        return new User(USER_NAME,USER_PASSWORD);
    }
}
