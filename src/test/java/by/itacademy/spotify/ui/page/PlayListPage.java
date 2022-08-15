package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PlayListPage extends AuthorizedHomePage {
    AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
    @FindBy(xpath = "//button[@data-testid='more-button']")
    private WebElement buttonMoreOptions;
    @FindBy(xpath = "//button[@class='wCkmVGEQh3je1hrbsFBY']")
    private WebElement buttonPlaylistName;
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
    @FindBy(xpath = " //button[@role='menuitem']//span[text()='Delete']")
    private WebElement buttonDeleteInMoreOptions;
    @FindBy(xpath = "//button[@aria-label='Remove from Your Library']")
    private WebElement buttonRemoveFromYourLibrary;
    @FindAll(@FindBy( how = How.XPATH, using = "//a[@data-testid='internal-track-link']"))
    private List<WebElement> listOfSongs;
    @FindBy(xpath = "//span[normalize-space()='Remove from this playlist']")
    private WebElement buttonDeleteFromPlaylist;
    @FindBy(xpath = "//div[@data-testid='playlist-tracklist']")
    private WebElement playlistTable;
    @FindBy(xpath = "//div[@data-testid='playlist-tracklist']//div[@role='row'][@aria-rowindex='2']//button[@data-testid='more-button']")
    private WebElement buttonFirstTrackOptions;

    public void clickButtonDeleteFromPlaylist() {
        waitForVisibilityOfElement(buttonDeleteFromPlaylist);
        buttonDeleteFromPlaylist.click();
    }

    public void clickFirstTrackOptions() {
        waitForElementToBeClickable(buttonMoreOptions);
        buttonFirstTrackOptions.click();

    }

    public List<String> getListOfSongLinks() {
        List<String> songLinks = new ArrayList<>();
        waitForVisibilityOfElement(playlistTable);
        for (WebElement song : listOfSongs) {
            String songLink = song.getAttribute("href");
            songLinks.add(songLink);
        }
        return songLinks;
    }

    public void waitForTrackListUpdate() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void hoverOverFirstTrackOptionsButtonElement()
    {
        Actions action = new Actions(driver);
        action.moveToElement(buttonFirstTrackOptions).perform();
    }
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

    public PlayListPage clickButtonMoreOptions() {
        waitForElementToBeClickable(buttonMoreOptions);
        buttonMoreOptions.click();
        return this;
    }

    public PlayListPage clickButtonDeleteInMoreOptions() {
        waitForElementToBeClickable(buttonDeleteInMoreOptions);
        buttonDeleteInMoreOptions.click();
        return this;
    }

    public PlayListPage clickButtonConfirmDeletePlaylist() {
        waitForElementToBeClickable(buttonConfirmDeletePlaylist);
        buttonConfirmDeletePlaylist.click();
        return this;
    }

    public PlayListPage clickButtonRemoveFromYourLibrary() {
        waitForElementToBeClickable(buttonRemoveFromYourLibrary);
        buttonRemoveFromYourLibrary.click();
        return this;
    }

    public PlayListPage deleteAllCreatedPlayLists() {
        try {
            while (isDisplayedButtonMadePlaylist()) {

                authorizedHomePage.clickButtonMadePlaylist();
                clickButtonMoreOptions()
                        .clickButtonDeleteInMoreOptions()
                        .clickButtonConfirmDeletePlaylist();
            }
        } catch (Exception e) {
        }
        return this;
    }

    public PlayListPage deleteAllNotCreatedPlaylists() {
        try {
            while (isDisplayedButtonNotCreatedPlaylist()) {
                authorizedHomePage.clickButtonNotCreatedPlaylist();
                new PlayListPage().clickButtonRemoveFromYourLibrary();
            }
        } catch (Exception e) {
        }
        return this;
    }
}
