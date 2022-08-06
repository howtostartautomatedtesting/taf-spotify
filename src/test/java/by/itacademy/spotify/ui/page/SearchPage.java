package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AuthorizedHomePage {

    String NameArtist = "Eminem";
    String NameOfSong = "Superman";

    @FindBy(xpath = "//span[@class='Type__TypeElement-goli3j-0 hWmToD ellipsis-one-line']")
    private WebElement search;
    @FindBy(xpath = "//input[@class='Type__TypeElement-goli3j-0 cPwEdQ QO9loc33XC50mMRUCIvf']")
    private WebElement clickOnSearch;
    @FindBy(xpath = "//input[@class='Type__TypeElement-goli3j-0 cPwEdQ QO9loc33XC50mMRUCIvf']")
    private WebElement inputNameArtist;
    @FindBy(xpath = "//input[@class='Type__TypeElement-goli3j-0 cPwEdQ QO9loc33XC50mMRUCIvf']")
    private WebElement inputNameOfSong;


    public String search() {
        search.click();
        return null;
    }
    public String clickOnSearch() {
        clickOnSearch.click();
        return null;
    }
    public String inputNameArtist() {
        inputNameArtist.getAttribute(NameArtist);
        return null;
    }
    public String inputNameOfSong() {
        inputNameOfSong.getAttribute(NameOfSong);
        return null;
    }
}
