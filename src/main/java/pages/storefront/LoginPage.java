package pages.storefront;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import utilities.UICommonAction;

import static utilities.links.Links.*;

import java.time.Duration;
import java.util.List;

public class LoginPage {
	
	final static Logger logger = LogManager.getLogger(LoginPage.class);
	
    WebDriver driver;
    WebDriverWait wait;
    UICommonAction commonAction;
    
    SoftAssert soft = new SoftAssert();
    
    public LoginPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonAction = new UICommonAction(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".navbar-brand.nav-link")
    WebElement USER_INFO_ICON;
    
    @FindBy(css = "#btn-login")
    WebElement LOGIN_ICON;
    
    @FindBy(css = "#login-username")
    WebElement USERNAME;

    @FindBy (css = "#login-password")
    WebElement PASSWORD;

    @FindBy (xpath = "(//button[@class='btn btn-primary btn-block btn-submit'])[1]")
    WebElement LOGIN_BTN;

    @FindBy (css = ".error + .error")
    List<WebElement> USER_PASSWORD_ERROR;

    @FindBy (css = "#login-fail")
    WebElement INVALID_USER_ERROR;	
	

    public LoginPage navigate() {
        driver.get(DOMAIN1);
        wait.until(ExpectedConditions.titleIs(LOGIN_PAGE_TITLE1));
        return this;
    }

    public LoginPage clickUserInfoIcon() {
    	commonAction.clickElement(USER_INFO_ICON);
    	logger.info("Clicked on User Info icon.");
        return this;
    }    
    
    public LoginPage clickLoginIcon() {
    	commonAction.clickElement(LOGIN_ICON);
    	logger.info("Clicked on Login icon.");    	
    	return this;
    }    
    
    public LoginPage inputEmailOrPhoneNumber(String username) {
    	commonAction.inputText(USERNAME, username);
    	logger.info("Input '" + username + "' into Username field.");
        return this;
    }

    public LoginPage inputPassword(String password) {
    	commonAction.inputText(PASSWORD, password);
    	logger.info("Input '" + password + "' into Password field.");
        return this;
    }

    public LoginPage clickLoginBtn() {
    	commonAction.clickElement(LOGIN_BTN);
    	logger.info("Clicked on Login button.");
        return this;
    }
    
    public LoginPage performLogin(String username, String password) {
    	clickUserInfoIcon();
    	clickLoginIcon();
    	inputEmailOrPhoneNumber(username);
    	inputPassword(password);
    	clickLoginBtn();
        return this;
    }
   
}
