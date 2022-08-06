package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AuthorizedHomePage {

    @FindBy(xpath = "//span[@class='Type__TypeElement-goli3j-0 hWmToD ellipsis-one-line']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement inputField;

    public void clickSearchButton() {
        searchButton.click();
    }

    public SearchPage inputFieldNameArtist(String name) {
        inputField.sendKeys(name);
        return this;
    }
}
