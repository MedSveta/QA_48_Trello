package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(xpath = "//button[@class='uNYBvavDBWmsZA FdcUZ8Pg9B6NNQ ybVBgfOiuWZJtD mUpWqmjL4CZBvn _St8_YSRMkLv07']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnCreateBoardSubmit;
    @FindBy(xpath = "//span[@class='VmbXKMJLSqfD0U']")
    WebElement popUpMessageBoardDelete;
    @FindBy(xpath = "//button[@class='kKCUvBL0NSbkMZ js-open-header-member-menu ZLTJF_ysLPgs1N PhzBALMp63PY_y ybVBgfOiuWZJtD _St8_YSRMkLv07']")
    WebElement btnAccount;
    @FindBy(xpath = "//span[text()='Manage account']")
    WebElement btnManageAccount;

    public void openMyAccount(){
        clickWait(btnAccount);
        clickWait(btnManageAccount);
    }

    public boolean validatePopUpMessage(String text){
        return validateTextInElement(popUpMessageBoardDelete, text);
    }

    public void createNewBoard(Board board) {
        btnCreateNewBoard.click();
        //clickWait(btnCreateNewBoard);
        inputBoardTitle.sendKeys(board.getBoardTitle());
    }

    public void clickBtnSubmit(){
        clickWait(btnCreateBoardSubmit);
    }

    public boolean validateUrl() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("boards"));
    }

    public boolean buttonCreateIsNotClickable(){
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions
                        .not(ExpectedConditions
                                .elementToBeClickable(btnCreateBoardSubmit)));
    }
}
