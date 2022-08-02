package utilities.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailElement {
    WebDriver driver;

    public MailElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#email-table > div >div.from_div_45g45gg")
    WebElement MAIL_ELEMENT;

    @FindBy (css = "div:nth-child(2) > span:nth-child(2)")
    WebElement PASSWORD;
}
