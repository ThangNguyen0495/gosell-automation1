package pages.dashboard.settings.staff_management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public StaffPage selectStaffPermission(List<Integer> roleList) {
        for (Integer role : roleList) {
            if (role < STAFF_PERMISSIONS.size()) {
                wait.until(ExpectedConditions.elementToBeClickable(STAFF_PERMISSIONS.get(role))).click();
            }
        }
        return this;
    }

    public StaffPage selectBranch(List<Integer> branchList) {
        for (Integer branch : branchList) {
            wait.until(ExpectedConditions.elementToBeClickable(STAFF_BRANCH.get(branch))).click();
        }
        return this;
    }

    public StaffPage clickDoneBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN)).click();
        return this;
    }

    public void logoutSellerAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BTN)).click();
    }
}
