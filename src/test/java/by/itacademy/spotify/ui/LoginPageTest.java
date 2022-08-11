package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.AuthorizedHomePage;
import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.utils.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLoginWithEmptyCredentials() {
        List<String> expectedErrorMessageText = new ArrayList<>();
        List<String> actualErrorMessageText = new ArrayList<>();
        String expectedErrorUsernameText = "Please enter your Spotify username or email address.";
        String expectedErrorPasswordText = "Please enter your password.";
        expectedErrorMessageText.add(expectedErrorUsernameText);
        expectedErrorMessageText.add(expectedErrorPasswordText);
        new HomePage().openPage().clickLogIn();

        LoginPage loginPage = new LoginPage();
        loginPage.waitForLoginButton()
                .typeUsername(Random.generateText())
                .clearUsername()
                .typePassword(Random.generateText())
                .clearPassword()
                .clickLogin();

        actualErrorMessageText.add(loginPage.getErrorUsernameText());
        actualErrorMessageText.add(loginPage.getErrorUPasswordText());
        Assert.assertEquals(expectedErrorMessageText, actualErrorMessageText);
    }

    @Test
    public void testLoginFormWithCorrectCredentials() {
        String userName = "itacamyspotifytest@gmail.com";
        String password = "Cvbn456))";
        String authorisedUserName = "user";
        AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
        new HomePage().openPage()
                .clickLogIn();
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(userName)
                .typePassword(password)
                .clickLogin();
        Assert.assertEquals(authorizedHomePage.getAccountMenuButtonText(), authorisedUserName);
    }
}
