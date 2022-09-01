package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.AuthorizedHomePage;
import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListPage;
import by.itacademy.spotify.ui.steps.AuthorizedStep;
import by.itacademy.spotify.ui.utils.UserCreator;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.List;

public class PlayListPageTest extends AuthorizedUserBaseTest {
    String USERNAME = "howtostartautomatedtesting@gmail.com";
    String PASSWORD = "h0W-2-sTArt-at";
    PlayListPage playListPage;

    @Test
    public void testDeletePlaylist() {
        //GIVEN
        AuthorizedStep.logIn(UserCreator.createDefaultUser());

        //WHEN
        playListPage = new PlayListPage();
        playListPage.clickButtonCreatePlayList();
        String actualPlayListName = playListPage.getPlayListName();
        List<String> resultListOfPlayList = playListPage.selectCreatedPlayList()
                .clickMoreOptions()
                .clickDeletePlaylist()
                .clickConfirmDeletePlaylist()
                .getListOfPlayLists();

        //THEN
        Assert.assertTrue(resultListOfPlayList.contains(actualPlayListName));
    }
        @Test
        public void testCreatePlaylist()  {
            //GIVEN
            HomePage homePage = new HomePage();
            homePage.openPage()
                    .clickLogIn();
            new LoginPage().typeUsername(USERNAME)
                    .typePassword(PASSWORD)
                    .clickLogin();
            //WHEN
            AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
            authorizedHomePage.waitForButtonCreatePlayList();
            PlayListPage playListPage = new PlayListPage();
            playListPage.deleteAllNotCreatedPlaylists()
                    .deleteAllCreatedPlayLists();
            authorizedHomePage.waitForButtonCreatePlayList()
                    .clickButtonCreatePlaylist()
                    .waitForVisibilePlayList();
            //THEN
            Assert.assertTrue(authorizedHomePage.isDisplayedButtonMadePlaylist());
        }

    @Test
    public void testRemoveSong() throws InterruptedException {
        //GIVEN
        new HomePage().openPage()
                .clickLogIn();
        new LoginPage().typeUsername(USERNAME)
                .typePassword(PASSWORD)
                .clickLogin();
        AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
        authorizedHomePage.clickButtonSidebarOpenTestPlaylist();

        //WHEN
        PlayListPage playListPage = new PlayListPage();
        List<String> trackListBeforeRemoval = playListPage.getListOfSongLinks();
        playListPage.hoverOverFirstTrackOptionsButtonElement();
        playListPage.clickFirstTrackOptions();
        playListPage.clickButtonDeleteFromPlaylist();
        playListPage.waitForTrackListUpdate();
        List<String> trackListAfterRemoval = playListPage.getListOfSongLinks();

        //THEN
        Assert.assertNotEquals(trackListAfterRemoval, trackListBeforeRemoval);
    }
}
