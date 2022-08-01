package pages.dashboard.settings.staff_management;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utilities.links.Links.*;

public class StaffPage extends StaffVerify {
    public StaffPage(WebDriver driver) {
        super(driver);
    }

    public StaffPage navigate() {
        driver.get(DOMAIN + SETTING_PATH);
        wait.until(ExpectedConditions.titleIs(SETTING_PAGE_TITLE));
        wait.until(ExpectedConditions.elementToBeClickable(STAFF_MANAGEMENT_MENU)).click();
        return this;
    }

    public StaffPage clickOnTheAddStaffBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_STAFF_BTN)).click();
        return this;
    }

    public StaffPage inputStaffName(String staffName) {
        wait.until(ExpectedConditions.elementToBeClickable(STAFF_NAME)).sendKeys(staffName);
        return this;
    }

    public StaffPage inputStaffMail(String staffMail) {
        wait.until(ExpectedConditions.elementToBeClickable(STAFF_MAIL)).sendKeys(staffMail);
        return this;
    }

    public StaffPage selectStaffPermission() {
        for (WebElement permission : STAFF_PERMISSIONS) {
//            wait.until(ExpectedConditions.elementToBeClickable(permission)).click();
            permission.click();
        }
        return this;
    }

    public StaffPage selectBranch() {
        for (WebElement branch : STAFF_BRANCH) {
            wait.until(ExpectedConditions.elementToBeClickable(branch)).click();
        }
        return this;
    }

    public void clickOnTheDoneBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN)).click();
    }
}
