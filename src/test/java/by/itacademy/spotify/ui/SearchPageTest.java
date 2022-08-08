package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.driver.DriverSingleton;
import by.itacademy.spotify.ui.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class SearchPageTest extends BaseTest {
    WebDriver webDriver;

    private final String URL = "https://open.spotify.com/";
    private final String SONGNAME = "Yellow Submarine";
    private final String USERNAME = "itacamyspotifytest@gmail.com";
    private final String PASSWORD = "Cvbn456))";

    @BeforeMethod
    public void beforeTest() {
        webDriver = DriverSingleton.getDriver();
        webDriver.get(URL);
        webDriver.manage()
                .window()
                .maximize();
    }

    @Test
    public void testSearchAndAddSong() throws InvocationTargetException, NullPointerException {
        HomePage homePage = new HomePage();
        homePage.clickLogIn();
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(USERNAME);
        loginPage.typePassword(PASSWORD);
        loginPage.clickLogin();
        AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
        authorizedHomePage.clickSearch();
        SearchPage searchPage = new SearchPage();
        searchPage.typeSearchQuery(SONGNAME)
                .clickButtonMoreFirstRow()
                .clickButtonAddToPlaylist()
                .clickButtonAddToTestPlayList();
        authorizedHomePage.clickButtonLibrary();
        PlayListPage playListPage = new PlayListPage();
        playListPage.clickButtonTestPlaylist();
        Assert.assertTrue(playListPage.isTextTestSong());
    }
}
