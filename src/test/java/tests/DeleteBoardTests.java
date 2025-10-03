package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

public class DeleteBoardTests extends AppManager {
   BoardsPage boardsPage;
    @BeforeMethod(alwaysRun = true)
    public void login(){
        User user = User.builder()
                .email("sveta1978medved@gmail.com")
                .password("Medqwerty12345!")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        Board board = Board.builder()
                .boardTitle("123Qwerty")
                .build();
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnSubmit();
    }

    @Test(groups = "smoke")
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.validatePopUpMessage("Board deleted."));
    }
}
