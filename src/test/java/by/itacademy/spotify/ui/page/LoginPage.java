package by.itacademy.spotify.ui.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final CharSequence[] charSequencesDeleteAll = {Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE};

    @FindBy(xpath = "//label[@for='login-username']")
    private WebElement labelUsername;

    @FindBy(xpath = "//label[@for='login-password']")
    private WebElement labelPassword;

    @FindBy(xpath = "//input[@data-testid='login-username']")
    private WebElement inputUsername;

    @FindBy(id = "login-password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@data-testid='username-error']/p")
    private WebElement errorUsername;

    @FindBy(xpath = "//div[@data-testid='password-error']")
    private WebElement errorPassword;

    public LoginPage typeUsername(String username) {
        waitForElementToBeClickable(inputUsername);
        inputUsername.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        waitForElementToBeClickable(inputPassword);
        inputPassword.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        waitForElementToBeClickable(buttonLogin);
        buttonLogin.click();
    }

    public LoginPage clearUsername() {
        clearInputField(inputUsername);
        return this;
    }

    public LoginPage clearPassword() {
        clearInputField(inputPassword);
        return this;
    }

    public String getErrorUsernameText() {
        return errorUsername.getText();
    }

    public String getErrorUPasswordText() {
        return errorPassword.getText();
    }

    private LoginPage clearInputField(WebElement inputField) {
        inputField.sendKeys(charSequencesDeleteAll);
        return this;
    }
}