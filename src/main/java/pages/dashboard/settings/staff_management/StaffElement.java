package pages.dashboard.settings.staff_management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaffElement {
    WebDriver driver;

    public StaffElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li:nth-child(5) > a.nav-link")
    WebElement STAFF_MANAGEMENT_MENU;

    @FindBy (css = "div.staff-management > div > div >button")
    WebElement ADD_STAFF_BTN;

    @FindBy (css = "#name")
    WebElement STAFF_NAME;

    @FindBy (css = "div.modal-body> div > div >input[name = 'email']")
    WebElement STAFF_MAIL;

    @FindBy (css = "div.permission__body > fieldset > div > div > div > div > label")
    List<WebElement> STAFF_PERMISSIONS;

    @FindBy (css = "div.branch__body > fieldset > div > div > div > div > label")
    List<WebElement> STAFF_BRANCH;

    @FindBy (css = "div.staff-modal__footer > button.gs-button__green")
    WebElement DONE_BTN;

    @FindBy (css = "div.header-right__ele-right > a[href='/logout']")
    WebElement LOGOUT_BTN;
}
