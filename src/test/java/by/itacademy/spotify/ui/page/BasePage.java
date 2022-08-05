package by.itacademy.spotify.ui.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class BasePage {
    private final static String URL = "https://open.spotify.com/";
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement exampleElement;

    @BeforeTest
    public void startTest() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    public void openUrl() {
        driver.manage().window().setSize(new Dimension(1280, 970));
        driver.get("URL");
        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector("element")));
        wait.until(ExpectedConditions.invisibilityOf(exampleElement));
        WebElement element = driver.findElement(By.id("some-id"));
        Assert.assertTrue(element.isDisplayed());
        element.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }

    @AfterClass
    public void finishTest() {
        driver.quit();
    }

}
