package pages.dashboard.settings.staff_management;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.assert_customize.AssertCustomize;
import utilities.role_matrix.RoleMatrix;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static utilities.links.Links.DOMAIN;

public class StaffVerify extends StaffElement {
    WebDriverWait wait;
    AssertCustomize assertCustomize;

    Logger logger = LogManager.getLogger(StaffVerify.class);

    Integer countFail = 0;

    public StaffVerify(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertCustomize = new AssertCustomize(driver);
    }

    public void checkNoPermission(int pageId) throws InterruptedException, IOException {
        driver.get(DOMAIN + new RoleMatrix().pagePath().get(pageId));
        logger.info("Access to %s page".formatted(new RoleMatrix().pageList().get(pageId)));
        sleep(1000);
        countFail = assertCustomize.assertEquals(countFail, driver.getCurrentUrl(),
                DOMAIN + "/404", "[URL] 404 page is not displayed.");
        logger.info("Verify that 404 page should be shown instead of %s".formatted(new RoleMatrix().pageList().get(pageId)));
    }

    public void checkPermission(int pageId) throws InterruptedException, IOException {
        String path = new RoleMatrix().pagePath().get(pageId);
        String title = new RoleMatrix().pageList().get(pageId);
        driver.get(DOMAIN + path);
        logger.info("Access to %s page".formatted(title));
        sleep(1000);
        countFail = assertCustomize.assertEquals(countFail, driver.getCurrentUrl().replace("/intro", ""),
                DOMAIN + path.replace("/intro",""), "[URL] %s page is not displayed.".formatted(title));
        logger.info(("Verify that current URL is: %s").formatted(DOMAIN + path));
        countFail = assertCustomize.assertEquals(countFail, driver.getTitle(), title, "[Title] %s title does not match.".formatted(title));
        logger.info("Verify that page should be %s".formatted(title));
    }

    public List<Integer> getRoleList(List<Integer> roleList) {
        List<Integer> list = new ArrayList<>();
        for (int role : roleList) {
            if (role < 15) {
                list.add(role);
            }
        }
        return list;
    }

    public List<Integer> mixRoleList(List<Integer> roleList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < new RoleMatrix().staffRoleEncode().get(0).size(); i++) {
            list.add(0);
        }
        for (int role : roleList) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + new RoleMatrix().staffRoleEncode().get(role).get(i));
            }
        }
        return list;
    }

    public StaffVerify verifyPermissionOfStaff(List<Integer> roleList) throws InterruptedException, IOException {
        roleList = getRoleList(roleList);
        List<Integer> list = mixRoleList(roleList);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                checkNoPermission(i);
            } else {
                checkPermission(i);
            }
        }
        return this;
    }

    public StaffVerify verifyCreateStaffSuccessfully() throws IOException {
        countFail = assertCustomize.assertEquals(countFail, wait.until(ExpectedConditions.visibilityOf(TOAST_MESSAGE)).getText(),
                "Created successfully!", "[Create Staff] Can not create staff");
        return this;
    }

    public StaffVerify verifyUpdateStaffSuccessfully() throws IOException {
        countFail = assertCustomize.assertEquals(countFail, wait.until(ExpectedConditions.visibilityOf(TOAST_MESSAGE)).getText(),
                "Updated successfully!", "[Update Staff] Can not update staff");
        return this;
    }

    public void verifyDeleteStaffSuccessfully() throws IOException {
        countFail = assertCustomize.assertEquals(countFail, wait.until(ExpectedConditions.visibilityOf(TOAST_MESSAGE)).getText(),
                "Deleted successfully!", "[Delete Staff] Can not delete staff");
    }

    public void completeVerify() {
        if (countFail > 0) {
            Assert.fail("[Failed] Fail %d cases".formatted(countFail));
        }
    }

    public void logout() throws InterruptedException {
        if (driver.getCurrentUrl().contains("404")) {
            driver.get(DOMAIN);
            sleep(3000);
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", LOGOUT_BTN);
        logger.info("Logout");
    }
}
