package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.driver.DriverSingleton;
import by.itacademy.spotify.ui.page.PlayListPage;
import org.testng.annotations.AfterMethod;

public class AuthorizedUserBaseTest {

    @AfterMethod
    public void finishTest() {
        PlayListPage playListPage = new PlayListPage();
        playListPage.deleteAllCreatedPlayLists();
        DriverSingleton.closeDriver();
    }
}