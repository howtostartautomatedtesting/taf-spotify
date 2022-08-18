package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.AuthorizedHomePage;
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
    @Test
    public void testLoginWithIncorrectCredentials() {
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

    @Test
    public void testLoginWithForbiddenCharacterInUsername() {
        // GIVEN
        String userName = Random.getForbiddenCharacter();
        String expectedErrorUsernameText = "Forbidden character(s) " + userName + " in username.";
        new HomePage().openPage()
                .clickLogIn();
        // WHEN
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(userName);
        // THEN
        Assert.assertEquals(expectedErrorUsernameText, loginPage.getErrorUsernameText());
    }
}
