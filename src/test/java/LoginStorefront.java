import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.storefront.LoginPage;

public class LoginStorefront extends BaseTest {
    
    @Test
    public void TC06_SF_LoginWithValidPhoneNumberAccount() {
        new LoginPage(driver).navigate()
        .performLogin("0856256079", "12345678x@X");
        org.testng.Assert.assertTrue(false, "OMG So bad!");
    }

    @Test
    public void TC07_SF_LoginWithValidMailAccount() {
        new LoginPage(driver).navigate()
        .performLogin("buyertest@mailnesia.com", "fortesting!4");
    }

    @AfterMethod
    public void tearDown() {
    	super.tearDown();
    }    

}
