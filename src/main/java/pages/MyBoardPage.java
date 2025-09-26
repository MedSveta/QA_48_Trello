package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage{
    public MyBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;
    @FindBy(xpath = "//button[@class='QCfb_k37Q8MX7C PhzBALMp63PY_y ybVBgfOiuWZJtD Yt_v_LmarJM9ZS _St8_YSRMkLv07']")
    WebElement btnDots;
    //@FindBy(xpath = "//button[@class='H4CRJnSRKY5a_I YYRfNoEtCHWP55 ybVBgfOiuWZJtD _St8_YSRMkLv07']")
    @FindBy(xpath = "//div[text()='Close board']")
    WebElement btnCloseBoard;
    @FindBy(xpath = "//*[@data-testid='popover-close-board-confirm']")
    WebElement btnClose;
    @FindBy(xpath = "//*[@data-testid='close-board-delete-board-button']")
    WebElement btnDeleteBoard;
    @FindBy(xpath = "//*[@data-testid='close-board-delete-board-confirm-button']")
    WebElement btnDelete;


    public boolean validateBoardName(String text){
        return validateTextInElement(boardName, text);
    }

    public void deleteBoard(){
        clickWait(btnDots);
        clickWait(btnCloseBoard);
        clickWait(btnClose);
        pause(3);
        btnDots.click();
        clickWait(btnDeleteBoard);
        clickWait(btnDelete);

    }

}
