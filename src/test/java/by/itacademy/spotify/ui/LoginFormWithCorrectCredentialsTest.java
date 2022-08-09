package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFormWithCorrectCredentialsTest extends BaseTest {
    private static final String username = "itacamyspotifytest@gmail.com";
    private static final String password = "Cvbn456))";
    private static final String authorisedUserName = "user";

    @Test
    public void testLoginFormWithCorrectCredentials() {
        new HomePage().openPage().clickLogIn();
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(username).typePassword(password).clickLogin();
        Assert.assertEquals(loginPage.getUserName(), authorisedUserName);
    }
}
