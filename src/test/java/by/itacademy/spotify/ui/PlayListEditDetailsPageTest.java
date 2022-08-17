package by.itacademy.spotify.ui;

import by.itacademy.spotify.ui.page.PlayListEditDetailsPage;
import by.itacademy.spotify.ui.page.PlayListPage;
import by.itacademy.spotify.ui.utils.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListEditDetailsPageTest extends BaseTest {
    PlayListPage playListPage;
    PlayListEditDetailsPage playListEditDetailsPage;

    @Test(groups = "edit-play-list")
    public void testEditDetailsWithCorrectData() {
        String userInputNamePlayList = Random.generateText();
        String userInputDescriptionPlayList = Random.generateText();

        //
        //добавление плейлиста
        playListPage = new PlayListPage()
                .clickButtonCreatePlayList();

        playListEditDetailsPage = new PlayListEditDetailsPage()
                .clickButtonCookieClose()
                .clickButtonDefaultPlayList()
                .typeName(userInputNamePlayList)
                .typeDescription(userInputDescriptionPlayList);

        // я не знаю для чего делать проверку дальнейших 3 ассертов. т.к.
        // нам нужно было проверить изменилось ли название плейлиста, а это последний ассерт.
        // Если же clickSave() поднять выше перед ассертами, то тогда когда выполнится это действие и закроется форма,
        // то ассерты с названием в данной форме высвечивающейся уже не пройдут проверку

        Assert.assertTrue(playListEditDetailsPage.isDisplayedHeaderDetails());
        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getUserInputNamePlayList());
        Assert.assertEquals(userInputDescriptionPlayList, playListEditDetailsPage.getUserInputDescriptionPlayList());

        playListEditDetailsPage
                .clickSave();

        Assert.assertEquals(userInputNamePlayList, playListEditDetailsPage.getNewUserNamePlayList(userInputNamePlayList));
    }
}
