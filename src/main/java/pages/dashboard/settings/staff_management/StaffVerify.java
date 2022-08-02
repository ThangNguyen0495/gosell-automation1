package pages.dashboard.settings.staff_management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.role_matrix.RoleMatrix;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static utilities.links.Links.DOMAIN;

public class StaffVerify extends StaffElement {
    WebDriverWait wait;
    SoftAssert soft = new SoftAssert();

    public StaffVerify(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkNoPermission(int functionId) throws InterruptedException {
        System.out.println(functionId + ": " +new RoleMatrix().pagePath().get(functionId));
        driver.get(DOMAIN + new RoleMatrix().pagePath().get(functionId));
        sleep(1000);
        soft.assertEquals(driver.getCurrentUrl(), DOMAIN + "/404", "[URL] 404 page is not displayed.");
    }

    public void checkPermission(int functionId) throws InterruptedException {
        String path = new RoleMatrix().pagePath().get(functionId);
        String title = new RoleMatrix().pageList().get(functionId);
        System.out.println(functionId + ": " + path);
        System.out.println(functionId + ": " + title);
        driver.get(DOMAIN + path);
        sleep(1000);
        soft.assertEquals(driver.getCurrentUrl(), DOMAIN + path, "[URL] %s page is not displayed.".formatted(title));
        soft.assertEquals(driver.getTitle(), title, "[Title] %s title does not match.".formatted(title));
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

    public StaffVerify verifyPermissionOfStaff(List<Integer> roleList) throws InterruptedException {
        roleList = getRoleList(roleList);
        List<Integer> list = mixRoleList(roleList);
        System.out.println(list);
        for (int i = 0; i < list.size() -1; i ++) {
            if (list.get(i) == 0) {
                checkNoPermission(i);
            } else {
                checkPermission(i);
            }
        }
        return this;
    }
    public void completeVerify() {
        soft.assertAll();
    }
}
