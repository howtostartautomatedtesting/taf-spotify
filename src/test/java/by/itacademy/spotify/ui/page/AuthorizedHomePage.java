package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedHomePage extends BasePage {
    @FindBy(xpath = "//span[@data-testid='user-widget-name']")
    private WebElement userName; //UserName

    @FindBy(xpath = "//button[@data-testid='create-playlist-button']") //WebElement  Create Playlist
    private WebElement buttonCreatePlaylist;

    @FindBy(xpath = "//a[@href='/search']") //WebElement link Search
    private WebElement buttonSearch;

    public void clickCreatePlaylistAuthorizedHomePage() {
        buttonCreatePlaylist.click();
    }

    public void clickButtonSearchAuthorizedHomePage() {
        buttonSearch.click();
    }
}

