package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedHomePage extends BasePage {

    @FindBy(xpath = "//span[@data-testid='user-widget-name']")
    private WebElement userName;
    @FindBy(xpath = "//button[@data-testid='create-playlist-button']")
    private WebElement buttonCreatePlaylist;
    @FindBy(xpath = "//a[@href='/search']")
    private WebElement buttonSearch;

    public void clickCreatePlaylist() {
        buttonCreatePlaylist.click();
    }

    public void clickSearch() {
        buttonSearch.click();
    }
}
