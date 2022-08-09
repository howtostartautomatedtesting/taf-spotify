package by.itacademy.spotify.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlayListEditDetailsPage extends PlayListPage {

    private final By NEW_USER_NAME_PLAYLIST = By.xpath("//span[@class='Type__TypeElement-goli3j-0 gJFKvJ VjIb8SfYTkc4wMpqqj3f']");
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//span[@class='Type__TypeElement-goli3j-0 gJFKvJ VjIb8SfYTkc4wMpqqj3f'][1]")
    private WebElement defaultPlaylist;

    @FindBy(xpath = "//div[@data-testid='playlist-edit-details-modal']/div[1]/h1")
    private WebElement headerEditDetails;

    @FindBy(xpath = "//input[@data-testid='playlist-edit-details-name-input']")
    private WebElement inputName;

    @FindBy(xpath = "//textarea[@data-testid='playlist-edit-details-description-input']                                                                                        ")
    private WebElement inputDescription;

    @FindBy(xpath = "//button[@data-testid='playlist-edit-details-save-button']")
    private WebElement buttonSave;

    @FindBy(xpath = "//span[contains(text(), 'Изменение сведений')]")
    private WebElement buttonChangeInfoPlayList;

    @FindBy(xpath = "//div[@id='onetrust-close-btn-container']//button")
    private WebElement buttonCookie;

    public void clickButtonDefaultPlayList() {
        waitForVisibilityOfElement(defaultPlaylist);
        actions.contextClick(defaultPlaylist).build().perform();
        waitForVisibilityOfElement(buttonChangeInfoPlayList);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void typeName(String name) {
        waitForVisibilityOfElement(inputName);
        inputName.clear();
        inputName.sendKeys(name);
    }

    public void typeDescription(String description) {
        waitForVisibilityOfElement(inputDescription);
        inputDescription.clear();
        inputDescription.sendKeys(description);
    }

    public void clickSave() {
        waitForVisibilityOfElement(buttonSave);
        buttonSave.click();
        waitForVisibilityOfElement(defaultPlaylist);
    }

    public void clickButtonCookieClose() {
        waitForVisibilityOfElement(buttonCookie);
        buttonCookie.click();
    }

    public String getUserInputNamePlayList() {
        return inputName.getAttribute("innerHTML");
    }

    public String getUserInputDescriptionPlayList() {
        return inputDescription.getText();
    }

    public String getNewUserNamePlayList(String newUserNamePlayList) {
        List<WebElement> elementName = driver.findElements(NEW_USER_NAME_PLAYLIST);
        String resultNamePlayList = "Default Name";
        for (WebElement elements : elementName) {
            String userNamePlayList = elements.findElement(NEW_USER_NAME_PLAYLIST).getText();
            if (userNamePlayList.equals(newUserNamePlayList)) {
                resultNamePlayList = newUserNamePlayList;
            }
        }

        return resultNamePlayList;
    }
}
