package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayListEditDetailsPage extends PlayListPage {

    @FindBy(xpath="/html/body/div[17]/div/div/div/div[1]/h1")
    private WebElement editDetailsTitle;

    @FindBy(xpath = "//*[@id=\"text-input-0a282661aa71b9a3\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@data-testid=\"playlist-edit-details-save-button\"]")
    private WebElement saveButton;

    public void editNameFieldValue(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
