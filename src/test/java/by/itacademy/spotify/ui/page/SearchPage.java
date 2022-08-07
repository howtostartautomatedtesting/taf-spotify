package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AuthorizedHomePage {

    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement inputSearch;

    public SearchPage typeSearchQuery(String query) {
        inputSearch.sendKeys(query);
        return this;
    }
}
