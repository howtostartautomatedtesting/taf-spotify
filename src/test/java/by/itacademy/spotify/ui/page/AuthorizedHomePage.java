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
    @FindBy(xpath = "//a[@href='/collection']")
    private WebElement buttonLibrary;
    @FindBy(xpath = "//li[@role='listitem']")
    private WebElement buttonMadePlaylist;
    @FindBy(xpath = " //div[@class='GlueDropTarget GlueDropTarget--playlists GlueDropTarget--folders']")
    private WebElement buttonNotCreatedPlaylist;
    @FindBy(xpath = "//li[@data-testid='rootlist-item'][contains(.,'Playlist for Edit Test')]")
    private WebElement buttonSidebarOpenTestPlaylist;

    public void clickButtonSidebarOpenTestPlaylist() {
        waitForElementToBeClickable(buttonSidebarOpenTestPlaylist);
        buttonSidebarOpenTestPlaylist.click();
    }

    public void clickSearch() {
        waitForElementToBeClickable(buttonSearch);
        buttonSearch.click();
    }

    public void clickButtonLibrary() {
        waitForElementToBeClickable(buttonLibrary);
        buttonLibrary.click();
    }

    public String getAccountMenuButtonText() {
        waitForElementToBeClickable(userName);
        return userName.getText();
    }

    public boolean isDisplayedButtonMadePlaylist() {
        return buttonMadePlaylist.isDisplayed();
    }

    public AuthorizedHomePage clickButtonMadePlaylist() {
        buttonMadePlaylist.click();
        return this;
    }

    public AuthorizedHomePage clickButtonCreatePlaylist() {
        buttonCreatePlaylist.click();
        return this;
    }

    public AuthorizedHomePage waitForButtonCreatePlayList() {
        waitForElementToBeClickable(buttonCreatePlaylist);
        return this;
    }

    public AuthorizedHomePage waitForVisibilePlayList() {
        waitForVisibilityOfElement(buttonMadePlaylist);
        return this;
    }

    public boolean isDisplayedButtonNotCreatedPlaylist() {
        return buttonNotCreatedPlaylist.isDisplayed();
    }

    public AuthorizedHomePage clickButtonNotCreatedPlaylist() {
        waitForElementToBeClickable(buttonNotCreatedPlaylist);
        buttonNotCreatedPlaylist.click();
        return this;
    }
}
