package by.itacademy.spotify.ui.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AuthorizedHomePage {

    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement inputSearch;
    @FindBy(xpath = "//div[@aria-rowindex='1']")
    private WebElement divFirstSearchRow;
    @FindBy(xpath = "//div[@aria-rowindex='1']/div/div/button[@data-testid='more-button']")
    private WebElement buttonMoreFirstRow;
    @FindBy(xpath = "(//button[@role='menuitem'])[5]")
    private WebElement buttonAddToPlaylist;
    @FindBy(xpath = "//*[@class='wC9sIed7pfp47wZbmU6m']//span[.='Playlist for Edit Test ']")
    private WebElement buttonAddToTestPlaylist;
    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement buttonSearchPlayList;
    @FindBy(xpath = "//div[@class='eelA_0lUVXP3DXSyqSl6']//li[@class='DuEPSADpSwCcO880xjUG'][2]")
    private WebElement buttonSearchNamePlayList;


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

    public SearchPage clickButtonSearchNamePlayList() {
        waitForElementToBeClickable(buttonSearchNamePlayList);
        buttonSearchNamePlayList.click();
        return this;
    }

}
