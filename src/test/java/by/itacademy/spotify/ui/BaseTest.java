package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static final String URL = "https://open.spotify.com/";
    protected WebDriver webDriver;

    @BeforeMethod
    public void beforeTest() {
        webDriver = DriverSingleton.getDriver();
        webDriver.get(URL);
    }

    @AfterMethod
    public void finishTest() {
        DriverSingleton.closeDriver();
    }
}
