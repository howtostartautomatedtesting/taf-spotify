package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PlayListPage extends AuthorizedHomePage {
    @FindBy(xpath = "//button[@data-testid='more-button']")
    private WebElement buttonMoreOptions;

    @FindBy(xpath = "//button[@class='wCkmVGEQh3je1hrbsFBY']")
    private WebElement buttonPlaylistName;
    @FindBy(xpath = "//a[@title='Playlist for Edit Test ']")
    private WebElement buttonOpenTestPlaylist;
    @FindBy(xpath = "//*[@class='JUa6JJNj7R_Y3i4P8YUX']//div[.='Yellow Submarine']")
    private WebElement textTestSong;

    @FindBy(xpath = "//a[@title='Playlist for Edit Test ']")
    private WebElement buttonOpenTestPlaylist;

    @FindBy(xpath = "//*[@class='JUa6JJNj7R_Y3i4P8YUX']//div[.='Yellow Submarine']")
    private WebElement textTestSong;

    @FindBy(xpath = "//li[@data-testid='rootlist-item'][1]//div[@class='AINMAUImkAYJd4ertQxy']")
    private WebElement playListItem;

    @FindBy(xpath = "//li[@data-testid='rootlist-item'][1]//span")
    private WebElement playListName;

    @FindBy(xpath = "//ul/li[5]/button")
    private WebElement buttonDeletePlaylist;

    @FindBy(xpath = "//div[@class='encore-light-theme awGNDbf1c8TGBAFR0pv8']//button[last()]")
    private WebElement buttonConfirmDeletePlaylist;

    @FindAll(@FindBy(how = How.XPATH, using = "//span[contains(@class,'Type__TypeElement-goli3j-0 gJFKvJ VjIb8SfYTkc4wMpqqj3f')]"))
    private List<WebElement> listOfPlayLists;

    public void clickPlaylistName() {
        buttonPlaylistName.click();
    }

    public PlayListPage clickMoreOptions() {
        waitForElementToBeClickable(buttonMoreOptions);
        buttonMoreOptions.click();
        return this;
    }

    public void clickButtonTestPlaylist() {
        waitForElementToBeClickable(buttonOpenTestPlaylist);
        buttonOpenTestPlaylist.click();
    }

    public boolean isTextTestSong() {
        waitForVisibilityOfElement(textTestSong);
        return textTestSong.isDisplayed();
    }

    public String getPlayListName() {
        waitForVisibilityOfElement(playListName);
        return playListName.getText();
    }

    public PlayListPage selectCreatedPlayList() {
        playListItem.click();
        return this;
    }

    public PlayListPage clickDeletePlaylist() {
        waitForElementToBeClickable(buttonDeletePlaylist);
        buttonDeletePlaylist.click();
        return this;
    }

    public PlayListPage clickConfirmDeletePlaylist() {
        waitForElementToBeClickable(buttonConfirmDeletePlaylist);
        buttonConfirmDeletePlaylist.click();
        return this;
    }

    public List<String> getListOfPlayLists() {
        List<String> namesPlayListsAsString = new ArrayList<>();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOfAllElements(listOfPlayLists));
        for (WebElement playlist : listOfPlayLists) {
            namesPlayListsAsString.add(playlist.getText());
        }
        return namesPlayListsAsString;
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
