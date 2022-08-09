package by.itacademy.spotify.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver driver;
    private static ChromeOptions options;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        options = new ChromeOptions()
                .addArguments("--lang=en");
        if (driver == null) {
            WebDriverManager
                    .chromedriver()
                    .setup();
            driver = new ChromeDriver(options);
            driver.manage()
                    .window()
                    .maximize();
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
