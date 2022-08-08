package by.itacademy.spotify.ui.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//button[@data-testid='login-button']")
    WebElement buttonLoginIn;

    public HomePage clickLoginIn() {
        buttonLoginIn.click();
        return this;
    }

    public HomePage openPage() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        driver = new ChromeDriver();
        return this;
    }
}
