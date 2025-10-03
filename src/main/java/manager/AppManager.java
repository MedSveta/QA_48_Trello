package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class AppManager {
    public Logger logger = LoggerFactory.getLogger(AppManager.class);
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    static String browser = System.getProperty("browser", "chrome");



    @BeforeMethod(alwaysRun = true)
    public void setup(Method method){
        //driver = new ChromeDriver();
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                logger.info("use chrome");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("use firefox");
                break;
            default:
                driver = new ChromeDriver();
                logger.info("use chrome");
                break;

        }
        driver.manage().window().maximize();
        logger.info("Start testing with method --> "+ method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method){
        if(driver != null)
            driver.quit();
        logger.info("End testing with method --> "+ method.getName());
    }
}
