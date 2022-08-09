package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListEditDetailsPage;
import by.itacademy.spotify.ui.utils.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListEditDetailsPageTest extends BaseTest {
    private final static String userInputNamePlayList = Random.generateText();
    private final static String userInputDescriptionPlayList = Random.generateText();

    @Test
    public void testEditDetailsWithCorrectData() {
        PlayListEditDetailsPage playListEditDetailsPage = new PlayListEditDetailsPage();
        HomePage homePage = new HomePage();
        LoginPage login = new LoginPage();

        homePage.openPage().clickLogIn();
        login.waitForLoginButton();
        login.typeUsername("itacamyspotifytest@gmail.com");
        login.typePassword("Cvbn456))");
        login.clickLogin();
        playListEditDetailsPage.clickButtonCookieClose();
        playListEditDetailsPage.clickButtonDefaultPlayList();
        playListEditDetailsPage.typeName(userInputNamePlayList);
        playListEditDetailsPage.typeDescription(userInputDescriptionPlayList);
        playListEditDetailsPage.clickSave();

        Assert.assertTrue(playListEditDetailsPage.isDisplayedHeaderDetails());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getUserInputNamePlayList());
        Assert.assertEquals(userInputDescriptionPlayList, playListEditDetailsPage.getUserInputDescriptionPlayList());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getNewUserNamePlayList(userInputNamePlayList));
    }
}
