package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.HomePage;
import by.itacademy.spotify.ui.page.LoginPage;
import by.itacademy.spotify.ui.page.PlayListPage;
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
}
