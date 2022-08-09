package by.itacademy.spotify.ui.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    CharSequence[] charSequencesDeleteAll = {Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE};

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

    @FindBy(xpath ="//button[@class='odcjv30UQnjaTv4sylc0']/span" )
    private WebElement buttonUser;

    public LoginPage typeUsername(String username) {
        waitForElementToBeClickable(inputUsername);
        inputUsername.click();
        inputUsername.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        inputPassword.click();
        inputPassword.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        buttonLogin.click();
    }

    public LoginPage clearUsername() {
        inputUsername.sendKeys(charSequencesDeleteAll);
        return this;
    }

    public LoginPage clearPassword() {
        inputPassword.sendKeys(charSequencesDeleteAll);
        return this;
    }

    public String getErrorUsernameText() {
        return errorUsername.getText();
    }

    public String getErrorUPasswordText() {
        return errorPassword.getText();
    }

    public LoginPage waitForLoginButton() {
        waitForElementToBeClickable(buttonLogin);
        return this;
    }

    public String getUserName(){
        waitForElementToBeClickable(buttonUser);
        return buttonUser.getText();
    }
}