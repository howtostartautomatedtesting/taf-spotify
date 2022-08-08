package by.itacademy.spotify.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PlayListEditDetailsPage extends PlayListPage {

    private final By NEW_USER_NAME_PLAYLIST = By.xpath("//div[@class='AINMAUImkAYJd4ertQxy']");
    Actions actions = new Actions(driver);
    @FindBy(xpath = "//span[@class='Type__TypeElement-goli3j-0 gJFKvJ VjIb8SfYTkc4wMpqqj3f']")
    private WebElement defaultPlaylist;
    @FindBy(xpath = "//span[contains(text(), 'Изменение сведений')]  ")
    private WebElement buttonChangingDetails;
    @FindBy(xpath = "//div[@data-testid='playlist-edit-details-modal']/div[1]/h1")
    private WebElement headerEditDetails;
    @FindBy(xpath = "//input[@data-testid='playlist-edit-details-name-input']")
    private WebElement inputName;
    @FindBy(xpath = "//textarea[@data-testid='playlist-edit-details-description-input']                                                                                        ")
    private WebElement inputDescription;
    @FindBy(xpath = "//button[@data-testid='playlist-edit-details-save-button']")
    private WebElement buttonSave;
    @FindBy(xpath = "//ul[@role='menu']")
    private WebElement contextMenu;
    @FindBy(xpath = "//h1[contains(text(), 'Изменить сведения')]  ")
    private WebElement modalWindow;
    @FindBy(xpath = "//span[contains(text(), 'Выбрать фото')]")
    private WebElement nameLabelPhoto;
    @FindBy(xpath = "//button[@data-testid ='edit-image-button']")
    private WebElement photoPlayList;

    public void clickButtonDefaultPlayList() {
        actions.
                contextClick(defaultPlaylist).
                build().
                perform();
    }

    public void clickButtonChangingDetails() {
        actions.contextClick(buttonChangingDetails).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.RETURN).
                build().
                perform();
    }

    public void typeName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
    }

    public void typeDescription(String description) {
        inputDescription.clear();
        inputDescription.sendKeys(description);
    }

    public void clickSave() {
        buttonSave.click();
    }

    public boolean isDisplayedContextMenu() {
        return contextMenu.isDisplayed();
    }

    public String getNameModalWindow() {
        return modalWindow.getText();
    }

    public String getUserInputNamePlayList() {
        return inputName.getText();
    }

    public String getUserInputDescriptionPlayList() {
        return inputDescription.getText();
    }

    public String getNameLabelPhoto() {
        return nameLabelPhoto.getText();
    }

    public boolean isDisplayedPhotoPlayList() {
        return photoPlayList.isDisplayed();
    }

    public String getNewUserNamePlayList(String newUserNamePlayList) {
        List<WebElement> elementName = driver.findElements(NEW_USER_NAME_PLAYLIST);
        String resultNamePlayList = "DefaultName";
        for (WebElement elements : elementName) {
            String userNamePlayList = elements.findElement(NEW_USER_NAME_PLAYLIST).getText();
            if (userNamePlayList.equals(newUserNamePlayList)) {
                resultNamePlayList = newUserNamePlayList;
            }
        }
        return resultNamePlayList;
    }
}
