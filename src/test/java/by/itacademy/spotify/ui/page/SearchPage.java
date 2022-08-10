package by.itacademy.spotify.ui.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AuthorizedHomePage {

    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement inputSearch;
    @FindBy(xpath = "//div[@aria-rowindex='1']")
    private WebElement divFirstSearchRow;
    @FindBy(xpath = "//div[@aria-rowindex='1']/div/div/button[@data-testid='more-button']")
    private WebElement buttonMoreFirstRow;
    @FindBy(xpath = "(//button[@class='wC9sIed7pfp47wZbmU6m'])[3]")
    private WebElement buttonAddToPlaylist;
    @FindBy(xpath = "//*[@class='wC9sIed7pfp47wZbmU6m']//span[.='Playlist for Edit Test ']")
    private WebElement buttonAddToTestPlaylist;

    public SearchPage() {
    }

    public SearchPage typeSearchQuery(String query) {
        waitForElementToBeClickable(inputSearch);
        inputSearch.sendKeys(query);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchPage clickButtonMoreFirstRow() {
        waitForVisibilityOfElement(divFirstSearchRow);
        buttonMoreFirstRow.click();
        return this;
    }

    public SearchPage clickButtonAddToPlaylist() {
        waitForElementToBeClickable(buttonAddToPlaylist);
        buttonAddToPlaylist.click();
        return this;
    }

    public SearchPage clickButtonAddToTestPlayList() {
        waitForElementToBeClickable(buttonAddToTestPlaylist);
        buttonAddToTestPlaylist.click();
        return this;
    }
}
