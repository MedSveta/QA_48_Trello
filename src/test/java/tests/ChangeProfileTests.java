package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AtlassianPage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestNgListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Listeners(TestNgListener.class)

public class ChangeProfileTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login(Method method) {
        User user = User.builder()
                .email("sveta1978medved@gmail.com")
                .password("Medqwerty12345!")
                .build();
        logger.info("start method --> " + method.getName()
                + " with user data: " + user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
    }

    @Test
    public void changeProfilePhoto(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianPage atlassianPage = new AtlassianPage(getDriver());
        atlassianPage.changeMyProfilePhoto("src/main/resources/cat3.png");
        Assert.assertTrue(atlassianPage.validateMessage("We've uploaded your new avatar." +
                " It may take a few minutes to display everywhere."));
    }

    @Test
    public void changeProfilePhotoNegative_WrongFormatFile(Method method){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        AtlassianPage atlassianPage = new AtlassianPage(getDriver());
        atlassianPage.changeMyProfilePhoto("src/main/resources/BoardTitle4.csv");
        logger.info("Upload file csv "+ method.getName());
        Assert.assertTrue(atlassianPage.
                validateMessageWrongFormatFile("Upload a photo or select from some default options"));
    }
    @Test
    public void changeProfilePhotoNegative_EmptyPath(Method method){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        AtlassianPage atlassianPage = new AtlassianPage(getDriver());
        atlassianPage.changeMyProfilePhoto("");
        logger.info("Upload file csv "+ method.getName());
        Assert.assertTrue(atlassianPage.
                validateMessageWrongFormatFile("Upload a photo or select from some default options"));
    }
}
