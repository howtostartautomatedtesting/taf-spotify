package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.driver.DriverSingleton;
import by.itacademy.spotify.ui.steps.AuthorizedStep;
import by.itacademy.spotify.ui.utils.UserCreator;
import org.testng.annotations.*;

public class BaseTest {


    @BeforeGroups("edit-play-list")
    public void logIn(){
        AuthorizedStep.logIn(UserCreator.createDefaultUser());
    }

    @AfterMethod
    public void finishTest() {
        DriverSingleton.closeDriver();
    }
}