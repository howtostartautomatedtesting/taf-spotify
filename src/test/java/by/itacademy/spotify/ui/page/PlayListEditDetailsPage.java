package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayListEditDetailsPage extends PlayListPage {

    @FindBy(xpath="//div[@data-testid='playlist-edit-details-modal']/div[1]/h1")
    private WebElement headerEditDetails;

    @FindBy(xpath = "//input[@data-testid='playlist-edit-details-name-input']")
    private WebElement inputName;

    @FindBy(xpath = "//button[@data-testid='playlist-edit-details-save-button']")
    private WebElement buttonSave;

    public void inputNameClearAndType(String name) {
        inputName.clear();
        inputName.sendKeys(name);
    }

    public void buttonSaveClick() {
        buttonSave.click();
    }
}
