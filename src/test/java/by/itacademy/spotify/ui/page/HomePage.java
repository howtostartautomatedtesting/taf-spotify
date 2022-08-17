package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement buttonLogIn;

    public LoginPage clickLogIn() {
        buttonLogIn.click();
        return new LoginPage();
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
