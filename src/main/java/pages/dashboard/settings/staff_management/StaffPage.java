package pages.dashboard.settings.staff_management;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.role_matrix.RoleMatrix;

import java.util.List;

import static java.lang.Thread.sleep;
import static utilities.links.Links.*;

public class StaffPage extends StaffVerify {

    Logger logger = LogManager.getLogger(StaffPage.class);
    public StaffPage(WebDriver driver) {
        super(driver);
    }

    public StaffPage navigate() throws InterruptedException {
        driver.get(DOMAIN + SETTING_PATH);
        logger.info("Access to Setting page");
        wait.until(ExpectedConditions.titleIs(SETTING_PAGE_TITLE));
        logger.info("Title of Setting page is %s".formatted(driver.getTitle()));
        wait.until(ExpectedConditions.elementToBeClickable(STAFF_MANAGEMENT_MENU)).click();
        logger.info("Switch to Staff Management tab");
        return this;
    }

    public StaffPage clickOnTheAddStaffBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_STAFF_BTN)).click();
        logger.info("Click on Add Staff button to open Add staff popup");
        return this;
    }

    public StaffPage inputStaffName(String staffName) {
        wait.until(ExpectedConditions.elementToBeClickable(STAFF_NAME)).sendKeys(staffName);
        logger.info("Input the staff name: %s".formatted(staffName));
        return this;
    }

    public StaffPage inputStaffMail(String staffMail) {
        wait.until(ExpectedConditions.elementToBeClickable(STAFF_MAIL)).sendKeys(staffMail);
        logger.info("Input the staff mail: %s".formatted(staffMail));
        return this;
    }

    public StaffPage selectStaffPermission(List<Integer> roleList) {
        for (Integer role : roleList) {
            if (role < STAFF_PERMISSIONS.size()) {
                wait.until(ExpectedConditions.elementToBeClickable(STAFF_PERMISSIONS.get(role))).click();
                logger.info("Add %s role to new staff".formatted(new RoleMatrix().staffRoleText().get(role)));
            }
        }
        return this;
    }

    public StaffPage selectBranch(List<Integer> branchList) {
        for (Integer branch : branchList) {
            wait.until(ExpectedConditions.elementToBeClickable(STAFF_BRANCH.get(branch))).click();
            logger.info("Assign %s branch to new staff". formatted(STAFF_BRANCH.get(branch).getText()));
        }
        return this;
    }

    public StaffPage clickDoneBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(DONE_BTN)).click();
        logger.info("Click on the Done button to complete create new staff");
        return this;
    }

    public void logoutSellerAccount() throws InterruptedException {
        driver.get(DOMAIN);
        sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", LOGOUT_BTN);
        logger.info("Logout seller account to login staff account and verify staff permission");
    }
}
