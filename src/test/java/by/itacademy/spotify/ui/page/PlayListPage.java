package by.itacademy.spotify.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayListPage extends AuthorizedHomePage{
    @FindBy(xpath = "//button[@class='T0anrkk_QA4IAQL29get']")
    private WebElement buttonMoreOptionsPlaylist;
    @FindBy(xpath = "//button[@class='wCkmVGEQh3je1hrbsFBY']")
    private WebElement buttonPlaylistName;

    public void clickButtonPlaylistName(){
        buttonPlaylistName.click();
    }
    public void clickButtonMoreOptionsPlaylist(){
        buttonMoreOptionsPlaylist.click();
    }

}

