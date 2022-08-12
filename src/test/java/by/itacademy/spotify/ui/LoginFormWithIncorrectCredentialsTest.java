package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFormWithIncorrectCredentialsTest extends BaseTest {
    @Test
    public void TestLoginFormWithIncorrectCredentials() {
        String login = "incorrectitacamyspotifytest@gmail.com";
        String password = "Cvbn456))";
        String expectedErrorMessage = "Incorrect username or password.";
        new HomePage()
                .openPage()
                .clickLogIn();
        LoginPage loginPage = new LoginPage()
                .typeUsername(login)
                .typePassword(password);
        loginPage.clickLogin();
        Assert.assertEquals(expectedErrorMessage, loginPage.getMessageIncorrectUserNameOrPassword());
    }
}
