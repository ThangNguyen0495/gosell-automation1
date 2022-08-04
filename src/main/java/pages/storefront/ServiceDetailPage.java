package pages.storefront;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.UICommonAction;
import utilities.assert_customize.AssertCustomize;

import java.io.IOException;
import java.time.Duration;

public class ServiceDetailPage {
    WebDriverWait wait;
    WebDriver driver;
    UICommonAction commons;
    AssertCustomize assertCustomize;
    int countFalse=0;
    final static Logger logger = LogManager.getLogger(ServiceDetailPage.class);

    public ServiceDetailPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commons = new UICommonAction(driver);
        assertCustomize = new AssertCustomize(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@rv-text='models.serviceName']")
    WebElement SERVICE_NAME;

    @FindBy(css = ".price")
    WebElement LISTING_PRICE;

    @FindBy(css = ".price-box .price")
    WebElement SELLING_PRICE;

    @FindBy(xpath = "//button[contains(@class,'buynow')]")
    WebElement BOOK_NOW_BTN;

    @FindBy(xpath = "//button[contains(@class,'clicktocart')]")
    WebElement ADD_TO_CART_BTN;

    @FindBy(xpath = "name='location'")
    WebElement LOCATION_DROPDOWN;

    @FindBy(xpath = "//select[@name='timeSlot'")
    WebElement TIMESLOT_DROPDOWN;

    public ServiceDetailPage verifyServiceName(String nameExpected) throws IOException {
        String nameActual= commons.getText(SERVICE_NAME);
        countFalse= assertCustomize.assertEquals(countFalse,nameActual,nameExpected,"Service name display: "+nameActual+" not match with expected "+nameExpected);
        logger.info("Verify service name display on detail page");
        return this;
    }
    public ServiceDetailPage verifyListingPrice(String listingPriceExpected) throws IOException {
        String listingPriceActual = commons.getText(LISTING_PRICE);
        countFalse= assertCustomize.assertEquals(countFalse,listingPriceActual,listingPriceExpected,"Listing price display: "+listingPriceActual+" not match withh expected: "+listingPriceExpected);
        logger.info("Verify service listing price on detail page");
        return this;
    }
    public ServiceDetailPage verifySellingPrice(String sellingPriceExpected) throws IOException {
        String sellingPriceActual = commons.getText(SELLING_PRICE);
        countFalse= assertCustomize.assertEquals(countFalse,sellingPriceActual,sellingPriceExpected,"Selling price display: "+sellingPriceActual+" not match withh expected: "+sellingPriceExpected);
        logger.info("Verify service selling price on detail page");
        return this;
    }
}
