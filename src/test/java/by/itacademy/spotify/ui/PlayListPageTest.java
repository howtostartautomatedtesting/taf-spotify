package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.driver.DriverSingleton;
import by.itacademy.spotify.ui.page.AuthorizedHomePage;
import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PlayListPageTest extends BaseTest {

    @Test
    public void testDeletePlaylist() {
        //GIVEN
        String USERNAME = "itacamyspotifytest@gmail.com";
        String PASSWORD = "Cvbn456))";
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
    public void testRemoveSong() throws InterruptedException {
        //given
        String URL = "https://open.spotify.com/";
        String username = "itacamyspotifytest@gmail.com";
        String password = "Cvbn456))";
        WebDriver webDriver = DriverSingleton.getDriver();
        webDriver.get(URL);
        webDriver.manage()
                .window()
                .maximize();
        HomePage homePage = new HomePage();
        homePage.clickLogIn();
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
        authorizedHomePage.clickButtonSidebarOpenTestPlaylist();

        //when
        PlayListPage playListPage = new PlayListPage();
        List<String> trackListBeforeRemoval = playListPage.getListOfSongLinks();
        playListPage.hoverOverFirstTrackOptionsButtonElement();
        playListPage.clickFirstTrackOptions();
        playListPage.clickButtonDeleteFromPlaylist();
        playListPage.waitForTrackListUpdate();
        List<String> trackListAfterRemoval = playListPage.getListOfSongLinks();

        //then
        Assert.assertNotEquals(trackListAfterRemoval, trackListBeforeRemoval);
    }
}
