package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//label[@for='login-username']")
    private WebElement labelUsername;
    @FindBy(xpath = "//label[@for='login-password']")
    private WebElement labelPassword;
    @FindBy(id = "login-username")
    private WebElement inputUsername;
    @FindBy(id = "login-password")
    private WebElement inputPassword;
    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    public void typeUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void typePassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        buttonLogin.click();
    }
}
