package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.AuthorizedHomePage;
import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListPage;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.List;

public class PlayListPageTest extends AuthorizedUserBaseTest {
    String USERNAME = "itacamyspotifytest@gmail.com";
    String PASSWORD = "Cvbn456))";
    @Test
    public void testDeletePlaylist() {
        //GIVEN

        new HomePage().openPage()
                .clickLogIn();
        new LoginPage().typeUsername(USERNAME)
                .typePassword(PASSWORD)
                .clickLogin();

        //WHEN
        PlayListPage playListPage = new PlayListPage();
        String actualPlayListName = playListPage.getPlayListName();
        List<String> resultListOfPlayList = playListPage.selectCreatedPlayList()
                .clickMoreOptions()
                .clickDeletePlaylist()
                .clickConfirmDeletePlaylist()
                .getListOfPlayLists();

        //THEN
        Assert.assertFalse(resultListOfPlayList.contains(actualPlayListName));
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
