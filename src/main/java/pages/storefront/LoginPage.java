package pages.storefront;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
    
    @FindBy(id = "btn-login")
    WebElement LOGIN_ICON;

    @FindBy (id = "login-country-code")
    WebElement COUNTRY_DROPDOWN;       
    
    @FindBy (id = "forgot-pwd-country-code")
    WebElement COUNTRY_FORGOT_DROPDOWN;       
    
    @FindBy(id = "login-username")
    WebElement USERNAME;
    
    @FindBy (id = "login-password")
    WebElement PASSWORD;    

    @FindBy (id = "open-forgot-pwd")
    WebElement FORGOT_PASSWORD;       
    
    @FindBy(id = "forgot-pwd-username")
    WebElement USERNAME_FORGOT_TXTBOX; 
    
    @FindBy(id = "verify-password")
    WebElement PASSWORD_FORGOT_TXTBOX;

    @FindBy (css = "#frm-forgot-pwd .btn-submit")
    WebElement CONTINUE_BTN;    
    
    @FindBy (css = "#frm-verify .btn-submit")
    WebElement CONFIRM_BTN;    

    @FindBy (id = "verify-code")
    WebElement VERIFICATION_CODE;       
    
    @FindBy (xpath = "(//button[@class='btn btn-primary btn-block btn-submit'])[1]")
    WebElement LOGIN_BTN;

    @FindBy (id = "login-username-error")
    WebElement USER_ERROR;

    @FindBy (id = "login-password-error")
    WebElement PASSWORD_ERROR;    

    @FindBy (id = "login-fail")
    WebElement INVALID_USER_ERROR;	
    
    public LoginPage navigate() {
        driver.get(DOMAIN1);
        wait.until(ExpectedConditions.titleIs(LOGIN_PAGE_TITLE1));
        return this;
    }
    public LoginPage navigate(String domain) {
        driver.get(domain);
        logger.debug("Page title is: "+driver.getTitle());
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

    public LoginPage selectCountry(String country) {
    	commonAction.clickElement(COUNTRY_DROPDOWN);
    	driver.findElement(By.xpath("//ul[@id='login-country-code-menu']//a[@class='dropdown-item']/span[text()='%s']".formatted(country))).click();
    	logger.info("Selected country: " + country);
    	return this;
    }        
    
    public LoginPage selectCountryForgot(String country) {
    	commonAction.clickElement(COUNTRY_FORGOT_DROPDOWN);
    	driver.findElement(By.xpath("//ul[@id='forgot-pwd-country-code-menu']//a[@class='dropdown-item']/span[text()='%s']".formatted(country))).click();
    	logger.info("Selected country: " + country);
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

    public LoginPage inputUsernameForgot(String username) {
    	commonAction.inputText(USERNAME_FORGOT_TXTBOX, username);
    	logger.info("Input '" + username + "' into Username field to get a new password.");
        return this;
    }

    public LoginPage inputPasswordForgot(String password) {
    	commonAction.inputText(PASSWORD_FORGOT_TXTBOX, password);
    	logger.info("Input '" + password + "' into Password field to get a new password.");
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

    public LoginPage performLogin(String country, String username, String password) {
    	clickUserInfoIcon();
    	clickLoginIcon();
    	selectCountry(country);
    	inputEmailOrPhoneNumber(username);
    	inputPassword(password);
    	clickLoginBtn();
    	return this;
    }    
    
    public LoginPage clickForgotPassword() {
    	commonAction.clickElement(FORGOT_PASSWORD);
    	logger.info("Clicked on Forgot Password linktext.");
    	return this;
    }    

    public LoginPage clickContinueBtn() {
    	commonAction.clickElement(CONTINUE_BTN);
    	logger.info("Clicked on Continue button.");
    	return this;
    }    
    
    public LoginPage clickConfirmBtn() {
    	commonAction.clickElement(CONFIRM_BTN);
    	logger.info("Clicked on Confirm button.");
    	return this;
    }    

    public LoginPage inputVerificationCode(String verificationCode) {
    	commonAction.inputText(VERIFICATION_CODE, verificationCode);
    	logger.info("Input '" + verificationCode + "' into Verification Code field.");
        return this;
    }   
    
    public LoginPage verifyEmailOrPhoneNumberError(String errMessage) {
        String text = commonAction.getText(USER_ERROR);
        soft.assertEquals(text, errMessage, "[Login][Email or Phone Number] Message does not match.");
        logger.info("verifyEmailOrPhoneNumberError completed");
        return this;
    }

    public LoginPage verifyPasswordError(String errMessage) {
        String text = commonAction.getText(PASSWORD_ERROR);
        soft.assertEquals(text,errMessage, "[Login][Password] Message does not match.");
        logger.info("verifyPasswordError completed");
        return this;
    }

    public LoginPage verifyEmailOrPasswordIncorrectError(String errMessage) {
        String text = commonAction.getText(INVALID_USER_ERROR);
        soft.assertEquals(text,errMessage, "[Login][Invalid Email/Password] Message does not match.");
        logger.info("verifyEmailOrPasswordIncorrectError completed");
        return this;
    }    
  
    public void completeVerify() {
        soft.assertAll();
    }    
    
}
