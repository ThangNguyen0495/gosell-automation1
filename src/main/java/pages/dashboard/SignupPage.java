package pages.dashboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.UICommonAction;
import utilities.database.InitConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import static utilities.links.Links.*;

public class SignupPage {

	final static Logger logger = LogManager.getLogger(SignupPage.class);
	
    WebDriver driver;
    WebDriverWait wait;
    UICommonAction commonAction;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonAction = new UICommonAction(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#username")
    WebElement USERNAME;

    @FindBy (css = "#password")
    WebElement PASSWORD;

    @FindBy (css = "button.uik-btn__iconRight")
    WebElement SIGNUP_BTN;

    @FindBy (css = "div.uik-select__valueWrapper>div>div:nth-child(2)")
    WebElement COUNTRY_CODE;

    @FindBy (css = "div.uik-select__valueRenderedWrapper")
    WebElement COUNTRY_DROPDOWN;

    @FindBy (css = "button.uik-select__option>span>div>div>div>div:nth-child(1)")
    List<WebElement> COUNTRY_LIST;

    @FindBy (css = "#verifyCode")
    WebElement OTP;

    @FindBy (css = ".btn-confirm")
    WebElement CONFIRM_OTP;

    @FindBy (css = ".resend-otp")
    WebElement RESEND_OTP;    
    
    public SignupPage navigate() {
        driver.get(DOMAIN + SIGNUP_PATH);
        wait.until(ExpectedConditions.titleIs(SIGNUP_PAGE_TITLE));
        return this;
    }
    public SignupPage selectCountry(String country) {
    	commonAction.clickElement(COUNTRY_DROPDOWN);
    	driver.findElement(By.xpath("//*[@class='uik-select__optionList']//div[@class='phone-option']/div[text()='%s']".formatted(country))).click();
    	logger.info("Selected country: " + country);
    	return this;
    }

    public SignupPage inputMailOrPhoneNumber(String user) {
    	commonAction.inputText(USERNAME, user);
    	logger.info("Input '" + user + "' into Username field.");
        return this;
    }

    public SignupPage inputPassword(String password) {
    	commonAction.inputText(PASSWORD, password);
    	logger.info("Input '" + password + "' into Password field.");
        return this;
    }

    public SignupPage clickSignupBtn() {
    	commonAction.clickElement(SIGNUP_BTN);
    	logger.info("Clicked on Signup button.");        
        return this;
    }

    public SignupPage fillOutSignupForm(String country, String user, String password) {
    	selectCountry(country);
    	inputMailOrPhoneNumber(user);
    	inputPassword(password);
    	clickSignupBtn();
        return this;
    }    
    
    public String getOTPCode(String userLoginDB) throws SQLException {
        Connection connection = new InitConnection().createConnection();
        String query = "select * from \"gateway-services\".jhi_user ju where login = '%s'".formatted(userLoginDB);
        ResultSet resultSet = connection.prepareStatement(query).executeQuery();
        String OTP_CODE = null;
        while (resultSet.next()) {
            OTP_CODE = resultSet.getString("activation_key");
        }
        logger.info("OTP Code retrieved: " + OTP_CODE); 
        return OTP_CODE;
    }    
    
    public SignupPage inputVerificationCode(String verificationCode) throws SQLException {
    	commonAction.inputText(OTP, verificationCode);
    	logger.info("Input '" + verificationCode + "' into Verification Code field.");
        return this;
    }

    public void clickConfirmBtn() {
    	commonAction.clickElement(CONFIRM_OTP);
    	logger.info("Clicked on Confirm button.");     
    }
    
}
