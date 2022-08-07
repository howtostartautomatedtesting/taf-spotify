package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayListPage extends AuthorizedHomePage {
    @FindBy(xpath = "//button[@data-testid='more-button']")
    private WebElement buttonMoreOptions;
    @FindBy(xpath = "//button[@class='wCkmVGEQh3je1hrbsFBY']")
    private WebElement buttonPlaylistName;

    public void clickPlaylistName() {
        buttonPlaylistName.click();
    }

    public void clickMoreOptions() {
        buttonMoreOptions.click();
    }
}
