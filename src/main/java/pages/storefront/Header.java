package pages.storefront;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.UICommonAction;

import java.time.Duration;

public class Header {
    WebDriver driver;
    WebDriverWait wait;
    UICommonAction commons;
    final static Logger logger = LogManager.getLogger(Header.class);

    public Header (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commons = new UICommonAction(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='custom-search-input']")
    WebElement SEARCH_FIELD_TO_CLICK;

    @FindBy(xpath = "//input[@type='search']")
    WebElement SEARCH_FIELD_TO_INPUT;

    @FindBy(xpath = "//h3[contains(@class,'search-result-item-title')]")
    WebElement SEARCH_SUGGESTION_RESULT_TITLE;

    @FindBy(xpath = "//strong[contains(@class,'search-result-item-price')]")
    WebElement SEARCH_SUGGESTION_RESULT_PRICE;

    public Header searchWithKeyWord(String keyword){
        commons.clickElement(SEARCH_FIELD_TO_CLICK);
        commons.inputText();
    }
}
