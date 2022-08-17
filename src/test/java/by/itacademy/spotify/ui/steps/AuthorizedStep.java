package by.itacademy.spotify.ui.steps;

import by.itacademy.spotify.ui.entity.User;
import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;

public class AuthorizedStep {
    public static LoginPage logIn(User user){
        return new HomePage().openPage()
                .clickLogIn()
                .authorize(user);
    }
}
