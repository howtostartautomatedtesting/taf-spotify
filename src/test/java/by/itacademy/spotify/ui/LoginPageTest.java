package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.utils.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLoginWithEmptyCredentials() {
        // GIVEN
        String expectedErrorUsernameText = "Please enter your Spotify username or email address.";
        String expectedErrorPasswordText = "Please enter your password.";
        new HomePage().openPage()
                .clickLogIn();

        // WHEN
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(Random.generateText())
                .clearUsername()
                .typePassword(Random.generateText())
                .clearPassword()
                .clickLogin();

        // THEN
        Assert.assertEquals(expectedErrorUsernameText, loginPage.getErrorUsernameText());
        Assert.assertEquals(expectedErrorPasswordText, loginPage.getErrorUPasswordText());
    }
}
