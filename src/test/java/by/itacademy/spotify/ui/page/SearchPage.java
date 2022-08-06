package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AuthorizedHomePage {

    private static final String NameArtist = "Eminem";
    private static final String NameOfSong = "Superman";

    @FindBy(xpath = "//span[@class='Type__TypeElement-goli3j-0 hWmToD ellipsis-one-line']")
    private WebElement search;
    @FindBy(xpath = "//input[@class='Type__TypeElement-goli3j-0 cPwEdQ QO9loc33XC50mMRUCIvf']")
    private WebElement inputTextForSearh;

    public String search() {
        search.click();
        return null;
    }
    public String clickOnSearch() {
        inputTextForSearh.click();
        return null;
    }
    public String inputNameArtist() {
        inputTextForSearh.getAttribute(NameArtist);
        return null;
    }
    public String inputNameOfSong() {
        inputTextForSearh.getAttribute(NameOfSong);
        return null;
    }
}
