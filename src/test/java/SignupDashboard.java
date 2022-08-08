import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.dashboard.LoginPage;
import pages.dashboard.SignupPage;
import pages.dashboard.home.HomePage;
import pages.Mailnesia;

import java.sql.SQLException;

public class SignupDashboard extends BaseTest{

	SignupPage signupPage;
	
//	String randomNumber = generate.generateNumber(3);
//	
//	String username = "automation0-shop" + randomNumber + "@mailnesia.com";
//	String password = "fortesting!1";
//	String country = "United Kingdom";
//	String countryCode = "+44";
//	String currency = "Pound Sterling - GBP(£)";
//	String language = "Tiếng Anh";
//	String storeName = "Automation Shop";
//	String storePhone = "9123456789";
//	String pickupAddress = "12 Hai Ba Trung";
//	String secondPickupAddress = "16 Nguyen Van Troi";
//	String city = "Ho Chi Minh";
//	String state = "Angus";
//	String zipCode = "987654";

	
    @BeforeMethod
    public void setup() throws InterruptedException {
    	super.setup();
    	signupPage = new SignupPage(driver);
    }		
	
    @Test
    public void SignupWithPhone() throws SQLException, InterruptedException {
    	String phone = "1122334455";
    	
    	signupPage.navigate()
                .fillOutSignupForm("Andorra", phone, "Abc@12345")
                .inputVerificationCode(signupPage.getOTPCode("+376:" + phone));
//                .clickConfirmBtn();
//        Thread.sleep(2000);
    }
    
    @Test
    public void SignupWithEmailThenCreateForeignShop() throws SQLException, InterruptedException {
    	
    	String randomNumber = generate.generateNumber(3);
    	
    	String username = "automation0-shop" + randomNumber + "@mailnesia.com";
    	String password = "fortesting!1";
    	String country = "United Kingdom";
    	String countryCode = "+44";
    	String currency = "Pound Sterling - GBP(£)";
    	String language = "Tiếng Anh";
    	String storeName = "Automation Shop " + randomNumber;
    	String storePhone = "9123456" + randomNumber;
    	String pickupAddress = "12 HighWay Revenue";
    	String secondPickupAddress = "16 Wall Street";
    	String city = "Cockney";
    	String state = "England";
    	String zipCode = "987654";
    	
    	
    	signupPage.navigate();
    	signupPage.fillOutSignupForm(country, username, password);
    	Thread.sleep(7000);
    	
    	// Get verification code from Mailnesia
    	commonAction.openNewTab();
    	commonAction.switchToWindow(1);
    	String verificationCode = new Mailnesia(driver).navigate(username).getVerificationCode();
    	commonAction.closeTab();
    	commonAction.switchToWindow(0);
    	
    	//Setup store
    	signupPage.inputVerificationCode(verificationCode);
    	signupPage.clickConfirmBtn();
    	signupPage.inputStoreName(storeName);
    	signupPage.selectCountryToSetUpShop(country);
    	signupPage.selectCurrency(currency);
    	signupPage.selectLanguage(language);
    	signupPage.inputStorePhone(storePhone);
    	signupPage.inputPickupAddress(pickupAddress);
    	signupPage.inputSecondPickupAddress(secondPickupAddress);
    	signupPage.inputCity(city);
    	signupPage.selectCityCode(state);
    	signupPage.inputZipCode(zipCode);
    	signupPage.clickCompleteBtn();
    	signupPage.clickLogout();
    	
    	// Re-login to the shop
        new LoginPage(driver).navigate().performLogin(username, password);
    	new HomePage(driver).clickUpgradeNow();
    	Thread.sleep(1000);
    	new HomePage(driver).waitTillSpinnerDisappear().clickLogout();
    	
    }
    
    @Test
    public void SignupWithEmailThenCreateVNShop() throws SQLException, InterruptedException {
    	
    	String randomNumber = generate.generateNumber(3);
    	
    	String username = "automation0-shop" + randomNumber + "@mailnesia.com";
    	String password = "fortesting!1";
    	String country = "Vietnam";
    	String countryCode = "+84";
    	String currency = "Dong - VND(₫)";
    	String language = "Tiếng Việt";
    	String storeName = "Automation Shop " + randomNumber;
    	String storePhone = "9123456" + randomNumber;
    	String pickupAddress = "12 Quang Trung";
    	String city = "Hồ Chí Minh";
    	String district = "Quận 8";
    	String ward = "Phường 2";
    	
    	
    	signupPage.navigate();
    	signupPage.fillOutSignupForm(country, username, password);
    	Thread.sleep(7000);
    	
    	// Get verification code from Mailnesia
    	commonAction.openNewTab();
    	commonAction.switchToWindow(1);
    	String verificationCode = new Mailnesia(driver).navigate(username).getVerificationCode();
    	commonAction.closeTab();
    	commonAction.switchToWindow(0);
    	
    	//Setup store
    	signupPage.inputVerificationCode(verificationCode);
    	signupPage.clickConfirmBtn();
    	signupPage.inputStoreName(storeName);
    	signupPage.selectCountryToSetUpShop(country);
    	signupPage.selectCurrency(currency);
    	signupPage.selectLanguage(language);
    	signupPage.inputStorePhone(storePhone);
    	signupPage.inputPickupAddress(pickupAddress);
    	signupPage.selectCityCode(city);
    	signupPage.selectDistrict(district);
    	signupPage.selectWard(ward);
    	signupPage.clickCompleteBtn();
    	signupPage.clickLogout();
    	
    	// Re-login to the shop
    	new LoginPage(driver).navigate().performLogin(username, password);
    	new HomePage(driver).clickUpgradeNow();
    	Thread.sleep(1000);
    	new HomePage(driver).waitTillSpinnerDisappear().clickLogout();
    	
    }
    
}
