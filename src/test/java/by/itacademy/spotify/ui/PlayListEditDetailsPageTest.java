package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListEditDetailsPage;
import by.itacademy.spotify.ui.utils.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListEditDetailsPageTest extends BaseTest {
    private final static String USER_INPUT_NAME_PLAY_LIST = Random.generateText();
    private final static String USER_INPUT_DESCRIPTION_PLAY_LIST = Random.generateText();
    private final static String USER_NAME = "itacamyspotifytest@gmail.com";
    private final static String USER_PASSWORD = "Cvbn456))";

    @Test
    public void testEditDetailsWithCorrectData() {
        PlayListEditDetailsPage playListEditDetailsPage = new PlayListEditDetailsPage();
        HomePage homePage = new HomePage();
        LoginPage login = new LoginPage();

        homePage.
                openPage().
                clickLogIn();
        login.
                waitForLoginButton().
                typeUsername(USER_NAME).
                typePassword(USER_PASSWORD).
                clickLogin();
        playListEditDetailsPage.
                clickButtonCookieClose().
                clickButtonDefaultPlayList().
                typeName(USER_INPUT_NAME_PLAY_LIST).
                typeDescription(USER_INPUT_DESCRIPTION_PLAY_LIST).
                clickSave();

        Assert.assertTrue(playListEditDetailsPage.isDisplayedHeaderDetails());
        Assert.assertEquals(USER_INPUT_NAME_PLAY_LIST, playListEditDetailsPage.getUserInputNamePlayList());
        Assert.assertEquals(USER_INPUT_DESCRIPTION_PLAY_LIST, playListEditDetailsPage.getUserInputDescriptionPlayList());
        Assert.assertEquals(USER_INPUT_NAME_PLAY_LIST, playListEditDetailsPage.getNewUserNamePlayList(USER_INPUT_NAME_PLAY_LIST));
    }
}
