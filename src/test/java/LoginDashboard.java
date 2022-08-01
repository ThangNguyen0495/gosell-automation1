import org.testng.annotations.Test;
import pages.dashboard.LoginPage;

import static utilities.account.AccountTest.*;
import static utilities.message.Message.*;

public class LoginDashboard extends BaseTest {
    @Test
    public void TC01_DB_LoginWithAllFieldsLeftBlank() {
        new LoginPage(driver).navigate()
                .performLogin("", "")
                .verifyEmailOrPhoneNumberError(BLANK_ERROR_MESSAGE)
                .verifyPasswordError(BLANK_ERROR_MESSAGE)
                .completeVerify();
    }

    @Test
    public void TC02_DB_LoginWithInvalidPhoneFormat() {
        new LoginPage(driver).navigate()
                .performLogin("123", PASSWORD)
                .verifyEmailOrPhoneNumberError(INVALID_PHONE_ERROR_MESSAGE)
                .completeVerify();
    }

    @Test
    public void TC03_DB_LoginWithInvalidMailFormat() {
        new LoginPage(driver).navigate()
                .performLogin("abc", PASSWORD)
                .verifyEmailOrPhoneNumberError(INVALID_MAIL_ERROR_MESSAGE)
                .completeVerify();
    }

    @Test
    public void TC04_DB_LoginWithInvalidEmailAccount() {
        new LoginPage(driver).navigate()
                .performLogin(generate.generateString(140) + "@nbobd.com", PASSWORD)
                .verifyEmailOrPasswordIncorrectError(INVALID_MAIL_OR_PASSWORD_ERROR)
                .completeVerify();
    }

    @Test
    public void TC05_DB_LoginWithInvalidPhoneAccount() {
        new LoginPage(driver).navigate()
                .performLogin(generate.generateNumber(13), PASSWORD)
                .verifyEmailOrPasswordIncorrectError(INVALID_MAIL_OR_PASSWORD_ERROR)
                .completeVerify();
    }

    @Test
    public void TC06_DB_LoginWithValidPhoneNumberAccount() {
        new LoginPage(driver).navigate()
                .performLogin(PHONE, PASSWORD);
    }

    @Test
    public void TC07_DB_LoginWithValidMailAccount() {
        new LoginPage(driver).navigate()
                .performLogin(MAIL, PASSWORD);
    }

    @Test
    public void TC08_DB_LoginWithFacebook() throws InterruptedException {
        new LoginPage(driver).navigate().performLoginWithFacebook("giaiphap.store@gmail.com", "RAPtor_1234%");
        Thread.sleep(10000);
    }
}
