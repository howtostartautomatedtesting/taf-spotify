package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.driver.DriverSingleton;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    @AfterMethod
    public void finishTest() {
        DriverSingleton.closeDriver();
    }
}
