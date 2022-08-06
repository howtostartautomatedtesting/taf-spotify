package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayListEditDetailsPage extends PlayListPage {

    @FindBy(xpath="//*[@data-testid=\"playlist-edit-details-modal\"]/div[1]/h1")
    private WebElement editDetailsTitle;

    @FindBy(xpath = "//*[@data-testid=\"playlist-edit-details-name-input\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@data-testid=\"playlist-edit-details-save-button\"]")
    private WebElement saveButton;

    public void inputNameClearAndType(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
