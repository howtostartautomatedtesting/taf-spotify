package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.PlayListEditDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListEditDetailsPageTest extends BaseTest {
    private final String nameModalWindow = "Изменить сведения";
    private final String userInputNamePlayList = "Modified Name ";
    private final String userInputDescriptionPlayList = "This is a playlist description";
    private final String nameLabelPhoto = "Выбрать фото";
    PlayListEditDetailsPage playListEditDetailsPage;

    @Test
    public void testEditDetailsWithCorrectData() {
        playListEditDetailsPage = new PlayListEditDetailsPage();
        Assert.assertTrue(playListEditDetailsPage.isDisplayedContextMenu());
        Assert.assertEquals(nameModalWindow, playListEditDetailsPage.getNameModalWindow());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getUserInputNamePlayList());
        Assert.assertEquals(userInputDescriptionPlayList, playListEditDetailsPage.getUserInputDescriptionPlayList());
        Assert.assertEquals(nameLabelPhoto, playListEditDetailsPage.getNameLabelPhoto());
        Assert.assertTrue(playListEditDetailsPage.isDisplayedPhotoPlayList());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getNewUserNamePlayList(userInputNamePlayList));
    }
}
