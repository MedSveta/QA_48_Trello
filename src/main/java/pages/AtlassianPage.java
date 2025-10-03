package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class AtlassianPage extends BasePage{
    public AtlassianPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    //@FindBy(xpath = "//button[@data-testid='profile-avatar-dropdown-trigger']")
    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement btnProfilePhoto;
    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement btnChangeProfilePhoto;
    @FindBy(xpath = "//input[@data-testid='image-navigator-input-file']")
    WebElement inputUploadPhoto;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnUpload;
    @FindBy(xpath = "//div[@class='_19itglyw _vchhusvi _r06hglyw _1bsb1osq']")
    WebElement popUpMessage;
    @FindBy(xpath = "//h2[@class='_1mouidpf _1dyz4jg8 _1p1dglyw _11c8140y _syaz15cr']")
    WebElement popUpMessageWrongFormat;

    public void changeMyProfilePhoto(String photoPath){
        //clickWait(btnProfilePhoto);
        pause(3);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto).pause(1500)
                .click().perform();
        clickWait(btnChangeProfilePhoto);

        File photo = new File(photoPath);
        System.out.println(photo.getAbsolutePath());
        inputUploadPhoto.sendKeys(photo.getAbsolutePath());

        clickWait(btnUpload);
    }

    public boolean validateMessage(String text){
        return validateTextInElement(popUpMessage, text);
    }

    public boolean validateMessageWrongFormatFile(String text){
        return validateTextInElement(popUpMessageWrongFormat, text);
    }
}
