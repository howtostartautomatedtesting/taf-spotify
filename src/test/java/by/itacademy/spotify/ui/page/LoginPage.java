package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//label[@for='login-username']")
    private WebElement usernameLabel;

    @FindBy(xpath = "//label[@for='login-password']")
    private WebElement passwordLabel;

    @FindBy(id = "login-username")
    private WebElement usernameInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void fillUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
