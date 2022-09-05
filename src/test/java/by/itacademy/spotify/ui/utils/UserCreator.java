package by.itacademy.spotify.ui.utils;

import by.itacademy.spotify.ui.entity.User;

public class UserCreator {
    public static final String USER_NAME = "howtostartautomatedtesting@gmail.com";
    public static final String USER_PASSWORD = "h0W-2-sTArt-at";

    public static User createDefaultUser(){
        return new User(USER_NAME,USER_PASSWORD);
    }
}
