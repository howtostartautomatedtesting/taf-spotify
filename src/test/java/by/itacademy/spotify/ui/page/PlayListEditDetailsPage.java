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
    @FindBy(xpath = "//li[@data-testid='rootlist-item']")
    private WebElement defaultPlaylist;
    @FindBy(xpath = "//div[@data-testid='playlist-edit-details-modal']/div[1]/h1")
    private WebElement headerEditDetails;
    @FindBy(xpath = "//input[@data-testid='playlist-edit-details-name-input']")
    private WebElement inputName;
    @FindBy(xpath = "//textarea[@data-testid='playlist-edit-details-description-input']                                                                                        ")
    private WebElement inputDescription;
    @FindBy(xpath = "//button[@data-testid='playlist-edit-details-save-button']")
    private WebElement buttonSave;
    @FindBy(xpath = "//li[@role='presentation'][4]")
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
        inputName.clear();
        waitForVisibilityOfElement(inputName);
        inputName.sendKeys(name);
    }

    public void typeDescription(String description) {
        inputDescription.clear();
        waitForVisibilityOfElement(inputDescription);
        inputDescription.sendKeys(description);
    }

    public void clickSave() {
        buttonSave.click();

    }

    public void clickButtonCookieClose() {
        waitForVisibilityOfElement(buttonCookie);
        buttonCookie.click();
    }

    public boolean isDisplayedHeaderDetails() {
        waitForVisibilityOfElement(headerEditDetails);
        return headerEditDetails.isEnabled();
    }

    public String getUserInputNamePlayList() {
        return inputName.getAttribute("value");
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
