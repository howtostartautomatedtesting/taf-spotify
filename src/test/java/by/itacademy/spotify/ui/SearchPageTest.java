package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.*;
import by.itacademy.spotify.ui.steps.AuthorizedStep;
import by.itacademy.spotify.ui.utils.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

    private final String SONG_NAME = "Yellow Submarine";
    PlayListPage playListPage;
    AuthorizedHomePage authorizedHomePage;
    PlayListEditDetailsPage playListEditDetailsPage;
    SearchPage searchPage;

    @Test
    public void testSearchAndAddSong(){
        // GIVEN
        AuthorizedStep.logIn(UserCreator.createDefaultUser());

        // WHEN
        playListPage = new PlayListPage()
                .clickButtonCreatePlayList();

        playListEditDetailsPage = new PlayListEditDetailsPage()
                .clickButtonCookieClose();

        authorizedHomePage = new AuthorizedHomePage();
        authorizedHomePage.clickSearch();

        searchPage = new SearchPage();
        searchPage.typeSearchQuery(SONG_NAME)
                .clickButtonMoreFirstRow()
                .clickButtonAddToPlaylist()
                .clickButtonSearchNamePlayList();

        playListPage = new PlayListPage()
                .clickButtonNamePlayList();

        // THEN
        Assert.assertEquals(playListPage.getTitleSongOfPlayList(), SONG_NAME);
    }
}
