package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListEditDetailsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlayListEditDetailsPageTest extends BaseTest {
    private final String userInputNamePlayList = "Modified Name";
    private final String userInputDescriptionPlayList = "This is a playlist description";

    PlayListEditDetailsPage playListEditDetailsPage = new PlayListEditDetailsPage();
    HomePage homePage = new HomePage();
    LoginPage login = new LoginPage();

    @BeforeClass
    public void testActionsStepsUser() {
        homePage.openPage();
        login.typeUsername("itacamyspotifytest@gmail.com");
        login.typePassword("Cvbn456))");
        login.clickLogin();
        login.clickButtonWebPlayer();
        playListEditDetailsPage.clickButtonCookieClose();
        playListEditDetailsPage.clickButtonDefaultPlayList();
        playListEditDetailsPage.typeName(userInputNamePlayList);
        playListEditDetailsPage.typeDescription(userInputDescriptionPlayList);
        playListEditDetailsPage.clickSave();

    }

    @Test
    public void testEditDetailsWithCorrectData() {
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getUserInputNamePlayList());
        Assert.assertEquals(userInputDescriptionPlayList, playListEditDetailsPage.getUserInputDescriptionPlayList());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getNewUserNamePlayList(userInputNamePlayList));
    }
}
