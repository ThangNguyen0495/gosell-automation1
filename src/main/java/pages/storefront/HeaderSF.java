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

import java.time.Duration;
import java.util.List;

public class HeaderSF {
    WebDriver driver;
    WebDriverWait wait;
    UICommonAction commons;
    final static Logger logger = LogManager.getLogger(HeaderSF.class);

    public HeaderSF(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        commons = new UICommonAction(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='custom-search-input']")
    WebElement SEARCH_FIELD_TO_CLICK;

    @FindBy(xpath = "//input[@type='search']")
    WebElement SEARCH_FIELD_TO_INPUT;

    @FindBy (css = ".lds-ellipsis")
    WebElement SEARCH_LOADING;
    @FindBy(xpath = "//h3[contains(@class,'search-result-item-title')]")
    List<WebElement> SEARCH_SUGGESTION_RESULT_TITLE;

    @FindBy(xpath = "//strong[contains(@class,'search-result-item-price')]")
    List<WebElement> SEARCH_SUGGESTION_RESULT_PRICE;

    @FindBy (id = "btn-logout")
    WebElement LOGOUT_BTN;    
    
    public HeaderSF searchWithFullName(String fullName){
        commons.clickElement(SEARCH_FIELD_TO_CLICK);
        logger.info("Click on Search bar");
        commons.inputText(SEARCH_FIELD_TO_INPUT,fullName);
        logger.info("Input: %s into search field".formatted(fullName));
        return this;
    }
    public HeaderSF verifySearchSuggestion(String fullName, String price){
        commons.waitForElementVisible(SEARCH_LOADING);
        commons.waitForElementInvisible(SEARCH_LOADING);
        String searchSuggestionItem1_Title = commons.getText(SEARCH_SUGGESTION_RESULT_TITLE.get(0));
        Assert.assertEquals(searchSuggestionItem1_Title,fullName);
        logger.info("Verify name: %s display on search suggestion".formatted(fullName));
        String searchSuggestionItem1_Price = commons.getText(SEARCH_SUGGESTION_RESULT_PRICE.get(0));
        Assert.assertEquals(String.join("",searchSuggestionItem1_Price.split(",")), price);
        logger.info("Verify price: %s display on search suggestion".formatted(price));
        return this;
    }
    public HeaderSF clickSearchResult (){
        commons.clickElement(SEARCH_SUGGESTION_RESULT_TITLE.get(0));
        logger.info("Click on the first suggestion to go to detail page");
        return this;
    }

    public void clickLogout(){
        commons.clickElement(LOGOUT_BTN);
        logger.info("Clicked on Logout linktext");
    }    
    
}
