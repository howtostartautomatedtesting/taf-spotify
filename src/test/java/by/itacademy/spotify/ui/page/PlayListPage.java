package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayListPage extends AuthorizedHomePage{
    @FindBy(xpath = "//button[@aria-label='More options for TestPlayList']")
    private WebElement buttonMoreOptionsPlaylist;
    @FindBy(xpath = "//li[@class='whXv9jYuEgS1DPTmPCe_']")
    private WebElement linkPlaylistName;

    public void clickLinkPlaylistName(){
        linkPlaylistName.click();
    }
    public void clickButtonMoreOptionsPlaylist(){
        buttonMoreOptionsPlaylist.click();
    }

}

