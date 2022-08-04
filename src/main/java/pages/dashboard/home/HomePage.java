package pages.dashboard.home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.UICommonAction;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    UICommonAction commons;
    WebDriverWait wait;
    final static Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        commons = new UICommonAction(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@name='component.navigation.services']")
    WebElement SERVICES_LINK;

    @FindBy (css = ".header-right__ele-right a[href='/logout']")
    WebElement LOGOUT_BTN;
    
    @FindBy (css = ".loading .lds-dual-ring-grey")
    WebElement SPINNER;    
    
    public HomePage goToSevices(){
        commons.clickElement(SERVICES_LINK);
        logger.info("Click on service item on menu");
        return this;
    }

    public HomePage waitTillSpinnerDisappear(){
        commons.waitTillElementDisappear(SPINNER, 15);
        logger.info("Spinner has finished loading");
        return this;
    }
    
    public HomePage clickLogout(){
        commons.clickElement(LOGOUT_BTN);
        logger.info("Clicked on Logout linktext");
        return this;
    }    

}
