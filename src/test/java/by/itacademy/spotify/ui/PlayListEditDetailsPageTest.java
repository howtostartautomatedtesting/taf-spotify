package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.PlayListEditDetailsPage;
import by.itacademy.spotify.ui.page.PlayListPage;
import by.itacademy.spotify.ui.steps.AuthorizedStep;
import by.itacademy.spotify.ui.utils.Random;
import by.itacademy.spotify.ui.utils.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListEditDetailsPageTest extends AuthorizedUserBaseTest {
    PlayListPage playListPage;
    PlayListEditDetailsPage playListEditDetailsPage;

    @Test
    public void testEditDetailsUI() {
        AuthorizedStep.logIn(UserCreator.createDefaultUser());
        String userInputNamePlayList = Random.generateText();
        String userInputDescriptionPlayList = Random.generateText();
        playListPage = new PlayListPage()
                .clickButtonCreatePlayList();

        playListEditDetailsPage = new PlayListEditDetailsPage()
                .clickButtonCookieClose()
                .clickButtonDefaultPlayList();

        Assert.assertTrue(playListEditDetailsPage.isDisplayedHeaderDetails());
    }

    @Test
    public void testEditDetailsWithCorrectData() {
        AuthorizedStep.logIn(UserCreator.createDefaultUser());
        String userInputNamePlayList = Random.generateText();
        String userInputDescriptionPlayList = Random.generateText();
        playListPage = new PlayListPage()
                .clickButtonCreatePlayList();

        playListEditDetailsPage = new PlayListEditDetailsPage()
                .clickButtonCookieClose()
                .clickButtonDefaultPlayList()
                .typeName(userInputNamePlayList)
                .typeDescription(userInputDescriptionPlayList)
                .clickSave();

        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getNewUserNamePlayList(userInputNamePlayList));
    }
}
