import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import pages.Mailnesia;
import pages.storefront.HeaderSF;
import pages.storefront.LoginPage;
import utilities.jsonFileUtility;

public class LoginStorefront extends BaseTest {

	String MAIL;
	String PASSWORD;
	String PHONE;
	String PHONE_PASSWORD;
	String BLANK_USERNAME_ERROR;
	String BLANK_PASSWORD_ERROR;
	String INVALID_USERNAME_ERROR;
	String INVALID_CREDENTIALS_ERROR;

	@BeforeClass
	public void readData() {
		JsonNode data = jsonFileUtility.readJsonFile("LoginInfo.json").findValue("storefront");

		MAIL = data.findValue("buyer").findValue("mail").findValue("username").asText();
		PASSWORD = data.findValue("buyer").findValue("mail").findValue("password").asText();
		PHONE = data.findValue("buyer").findValue("phone").findValue("username").asText();
		PHONE_PASSWORD = data.findValue("buyer").findValue("phone").findValue("password").asText();

		BLANK_USERNAME_ERROR = data.findValue("emptyUsernameError").asText();
		BLANK_PASSWORD_ERROR = data.findValue("emptyPasswordError").asText();
		INVALID_USERNAME_ERROR = data.findValue("invalidUsernameFormat").asText();
		INVALID_CREDENTIALS_ERROR = data.findValue("invalidCredentials").asText();
	}

	@Test
	public void TC01_SF_LoginWithAllFieldsLeftBlank() {
		new LoginPage(driver).navigate()
		.performLogin("", generate.generateNumber(9))
		.verifyEmailOrPhoneNumberError(BLANK_USERNAME_ERROR)
		.completeVerify();
		// Password field is left empty.
		new LoginPage(driver).navigate()
		.performLogin(generate.generateNumber(9), "")
		.verifyPasswordError(BLANK_PASSWORD_ERROR)
		.completeVerify();
		// All fields are left empty.
		new LoginPage(driver).navigate()
		.performLogin("", "")
		.verifyEmailOrPhoneNumberError(BLANK_USERNAME_ERROR)
		.verifyPasswordError(BLANK_PASSWORD_ERROR)
		.completeVerify();
	}

    @Test
    public void TC02_SF_LoginWithInvalidPhoneFormat() {
    	// Log in with a phone number consisting of 7 digits.
        new LoginPage(driver).navigate()
                .performLogin(generate.generateNumber(7), generate.generateString(10))
                .verifyEmailOrPhoneNumberError(INVALID_USERNAME_ERROR)
                .completeVerify();
        // Log in with a phone number consisting of 16 digits.
        new LoginPage(driver).navigate()
        		.performLogin(generate.generateNumber(16), generate.generateString(10))
                .verifyEmailOrPhoneNumberError(INVALID_USERNAME_ERROR)
                .completeVerify();
    }	

    @Test
    public void TC03_SF_LoginWithInvalidMailFormat() {
        new LoginPage(driver).navigate()
                .performLogin(generate.generateString(10), generate.generateString(10))
                .verifyEmailOrPhoneNumberError(INVALID_USERNAME_ERROR)
                .completeVerify();
    }    
 
    @Test
    public void TC04_SF_LoginWithWrongEmailAccount() {
        new LoginPage(driver).navigate()
                .performLogin(generate.generateString(10) + "@nbobd.com", generate.generateString(10))
                .verifyEmailOrPasswordIncorrectError(INVALID_CREDENTIALS_ERROR)
                .completeVerify();
    }    

    @Test
    public void TC05_SF_LoginWithWrongPhoneAccount() {
        new LoginPage(driver).navigate()
                .performLogin(generate.generateNumber(13), generate.generateString(10))
                .verifyEmailOrPasswordIncorrectError(INVALID_CREDENTIALS_ERROR)
                .completeVerify();
    }    

    @Test
    public void TC06_SF_LoginWithCorrectPhoneAccount() throws InterruptedException {
        new LoginPage(driver).navigate()
                .performLogin(PHONE, PHONE_PASSWORD);
        Thread.sleep(1000);
        new LoginPage(driver).clickUserInfoIcon();
        new HeaderSF(driver).clickLogout();
    }    

    @Test
    public void TC07_SF_LoginWithCorrectMailAccount() throws InterruptedException {
        new LoginPage(driver).navigate()
                .performLogin(MAIL, PASSWORD);
        Thread.sleep(1000);
        new LoginPage(driver).clickUserInfoIcon();
        new HeaderSF(driver).clickLogout();
    }    

  //Don't run this test case. It should only be run in regression test.
//  @Test
  public void TC10_SF_ForgotPassword() throws InterruptedException {
  	String newPassword = PASSWORD + "@" + generate.generateNumber(3);
  	
  	new LoginPage(driver).navigate()
  	.clickUserInfoIcon()
  	.clickLoginIcon()
  	.clickForgotPassword()
  	.inputUsernameForgot(MAIL)
  	.clickContinueBtn()
  	.inputPasswordForgot(newPassword);
  	
  	// Get verification code from Mailnesia
  	Thread.sleep(7000);
  	commonAction.openNewTab(); // Open a new tab
  	commonAction.switchToWindow(1); // Switch to the newly opened tab
  	String verificationCode = new Mailnesia(driver).navigate(MAIL).getVerificationCode(); // Get verification code
  	commonAction.closeTab(); // Close the newly opened tab
  	commonAction.switchToWindow(0); // Switch back to the original tab
  	
	new LoginPage(driver).inputVerificationCode(verificationCode)
	.clickConfirmBtn();
    Thread.sleep(1000);
    new LoginPage(driver).clickUserInfoIcon();
    new HeaderSF(driver).clickLogout();
    
	// Re-login with new password
	new LoginPage(driver).navigate()
	.performLogin(MAIL, newPassword);
	Thread.sleep(1000);
    new LoginPage(driver).clickUserInfoIcon();
    new HeaderSF(driver).clickLogout();
  }
  
}
