package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayListPage extends AuthorizedHomePage {
    @FindBy(xpath = "//button[@data-testid='more-button']")
    private WebElement buttonMoreOptions;
    @FindBy(xpath = "//button[@class='wCkmVGEQh3je1hrbsFBY']")
    private WebElement buttonPlaylistName;
    @FindBy(xpath = "//a[@title='Playlist for Edit Test ']")
    private WebElement buttonOpenTestPlaylist;
    @FindBy(xpath = "//*[@class='JUa6JJNj7R_Y3i4P8YUX']//div[.='Yellow Submarine']")
    private WebElement textTestSong;

    public void clickPlaylistName() {
        buttonPlaylistName.click();
    }

    public void clickMoreOptions() {
        buttonMoreOptions.click();
    }

    public void clickButtonTestPlaylist() {
        waitForElementToBeClickable(buttonOpenTestPlaylist);
        buttonOpenTestPlaylist.click();
    }
    public boolean isTextTestSong() {
        waitForVisibilityOfElement(textTestSong);
        return textTestSong.isDisplayed();
    }
}
