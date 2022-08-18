package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.driver.DriverSingleton;
import by.itacademy.spotify.ui.page.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends AuthorizedUserBaseTest {
    WebDriver webDriver;

    private final String URL = "https://open.spotify.com/";
    private final String SONGNAME = "Yellow Submarine";
    private final String USERNAME = "itacamyspotifytest@gmail.com";
    private final String PASSWORD = "Cvbn456))";

    @Test
    public void testSearchAndAddSong() {
        // GIVEN
        webDriver = DriverSingleton.getDriver();
        webDriver.get(URL);
        webDriver.manage()
                .window()
                .maximize();
        HomePage homePage = new HomePage();
        homePage.clickLogIn();
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(USERNAME);
        loginPage.typePassword(PASSWORD);
        loginPage.clickLogin();

        // WHEN
        AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
        authorizedHomePage.clickSearch();
        SearchPage searchPage = new SearchPage();
        searchPage.typeSearchQuery(SONGNAME)
                .clickButtonMoreFirstRow()
                .clickButtonAddToPlaylist()
                .clickButtonAddToTestPlayList();

        // THEN
        authorizedHomePage.clickButtonLibrary();
        PlayListPage playListPage = new PlayListPage();
        playListPage.clickButtonTestPlaylist();
        Assert.assertTrue(playListPage.isTextTestSong());
    }
}
