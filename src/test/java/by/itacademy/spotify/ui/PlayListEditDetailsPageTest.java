package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListEditDetailsPage;
import by.itacademy.spotify.ui.utils.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListEditDetailsPageTest extends BaseTest {

    @Test
    public void testEditDetailsWithCorrectData() {
        String userInputNamePlayList = Random.generateText();
        String userInputDescriptionPlayList = Random.generateText();
        String userName = "itacamyspotifytest@gmail.com";
        String userPassword = "Cvbn456))";

        HomePage homePage = new HomePage();
        homePage
                .openPage()
                .clickLogIn();

        LoginPage login = new LoginPage();
        login
                .typeUsername(userName)
                .typePassword(userPassword)
                .clickLogin();

        PlayListEditDetailsPage playListEditDetailsPage = new PlayListEditDetailsPage();
        playListEditDetailsPage
                .clickButtonCookieClose()
                .clickButtonDefaultPlayList()
                .typeName(userInputNamePlayList)
                .typeDescription(userInputDescriptionPlayList)
                .clickSave();

        Assert.assertTrue(playListEditDetailsPage.isDisplayedHeaderDetails());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getUserInputNamePlayList());
        Assert.assertEquals(userInputDescriptionPlayList, playListEditDetailsPage.getUserInputDescriptionPlayList());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getNewUserNamePlayList(userInputNamePlayList));
    }
}
