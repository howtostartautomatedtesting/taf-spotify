package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AuthorizedHomePage {

    @FindBy(xpath = "//span[@class='Type__TypeElement-goli3j-0 hWmToD ellipsis-one-line']")
    private WebElement clickSearch;
    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement inputNameArtist;

    public void clickSearch() {
        clickSearch.click();
    }

    public SearchPage inputNameArtist(String name) {
        inputNameArtist.sendKeys(name);
        return this;
    }
}
