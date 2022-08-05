import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.dashboard.LoginPage;
import pages.dashboard.home.HomePage;
import utilities.jsonFileUtility;

public class LoginDashboard extends BaseTest {
	
    String MAIL = "qcgosell01@gmail.com";
    String PASSWORD = "Psso12!@";
    String PHONE = "0363530754";
    String PHONE_PASSWORD = "Abc@12345";
    
    String BLANK_ERROR;
    String INVALID_MAIL_ERROR;
    String INVALID_PHONE_ERROR;
    String INVALID_CREDENTIALS_ERROR;
	
    @BeforeClass
    public void readData() {
    	try {
			BLANK_ERROR = jsonFileUtility.readJsonFile("DBInfo.json").findValue("dashboard").findValue("emptyError").asText();
			INVALID_MAIL_ERROR = jsonFileUtility.readJsonFile("DBInfo.json").findValue("dashboard").findValue("invalidMailFormat").asText();
			INVALID_PHONE_ERROR = jsonFileUtility.readJsonFile("DBInfo.json").findValue("dashboard").findValue("invalidPhoneFormat").asText();
			INVALID_CREDENTIALS_ERROR = jsonFileUtility.readJsonFile("DBInfo.json").findValue("dashboard").findValue("invalidCredentials").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }	    
    
    @Test
    public void TC01_DB_LoginWithAllFieldsLeftBlank() {
        new LoginPage(driver).navigate()
                .performLogin("", "")
                .verifyEmailOrPhoneNumberError(BLANK_ERROR)
                .verifyPasswordError(BLANK_ERROR)
                .completeVerify();
    }

    @Test
    public void TC02_DB_LoginWithInvalidPhoneFormat() {
        new LoginPage(driver).navigate()
                .performLogin("123", PASSWORD)
                .verifyEmailOrPhoneNumberError(INVALID_PHONE_ERROR)
                .completeVerify();
    }

    @Test
    public void TC03_DB_LoginWithInvalidMailFormat() {
        new LoginPage(driver).navigate()
                .performLogin("abc", PASSWORD)
                .verifyEmailOrPhoneNumberError(INVALID_MAIL_ERROR)
                .completeVerify();
    }

    @Test
    public void TC04_DB_LoginWithInvalidEmailAccount() {
        new LoginPage(driver).navigate()
                .performLogin(generate.generateString(140) + "@nbobd.com", PASSWORD)
                .verifyEmailOrPasswordIncorrectError(INVALID_CREDENTIALS_ERROR)
                .completeVerify();
    }

    @Test
    public void TC05_DB_LoginWithInvalidPhoneAccount() {
        new LoginPage(driver).navigate()
                .performLogin(generate.generateNumber(13), PASSWORD)
                .verifyEmailOrPasswordIncorrectError(INVALID_CREDENTIALS_ERROR)
                .completeVerify();
    }

    @Test
    public void TC06_DB_LoginWithValidPhoneNumberAccount() {
        new LoginPage(driver).navigate()
                .performLogin(PHONE, PHONE_PASSWORD);
        new HomePage(driver).waitTillSpinnerDisappear().clickLogout();
    }

    @Test
    public void TC07_DB_LoginWithValidMailAccount() {
        new LoginPage(driver).navigate()
                .performLogin(MAIL, PASSWORD);
        new HomePage(driver).waitTillSpinnerDisappear().clickLogout();
    }

    @Test
    public void TC08_DB_LoginWithFacebook() {
        new LoginPage(driver).navigate().performLoginWithFacebook("trangthuy9662@gmail.com", "123456aA@");     
        new HomePage(driver).waitTillSpinnerDisappear().clickLogout();
    }
    
    @Test
    public void TC09_DB_StaffLoginWithValidMailAccount() {
        new LoginPage(driver).navigate()
        		.switchToStaffTab()
                .performLogin("etrelwitdi@mailnesia.com", "uBMolFhj");
        new HomePage(driver).waitTillSpinnerDisappear().clickLogout();
    }    
}
