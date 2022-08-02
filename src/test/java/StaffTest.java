import org.testng.annotations.Test;
import pages.dashboard.LoginPage;
import pages.dashboard.settings.staff_management.StaffPage;
import pages.dashboard.settings.staff_management.StaffVerify;
import utilities.mail.MailPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class StaffTest extends BaseTest {
    @Test
    public void createStaff() throws InterruptedException {
        String staffName = "staff 12910";
        String staffMail = "staff12910x2@nbobd.com";
        List<Integer> staffRole  = List.of(1,2,9, 10);
        List<Integer> staffBranch = List.of(0);
        new LoginPage(driver).navigate()
                .inputEmailOrPhoneNumber("stgaboned@nbobd.com")
                .inputPassword("Abc@12345")
                .clickLoginBtn();

        sleep(3000);

        new StaffPage(driver).navigate()
                .clickOnTheAddStaffBtn()
                .inputStaffName(staffName)
                .inputStaffMail(staffMail)
                .selectStaffPermission(staffRole)
                .selectBranch(staffBranch)
                .clickDoneBtn()
                .logoutSellerAccount();

        new LoginPage(driver).navigate()
                .switchToStaffTab()
                .inputEmailOrPhoneNumber(staffMail)
                .inputPassword(new MailPage(driver).openMail(staffMail).getPassword())
                .clickLoginBtn();

        sleep(3000);

        new StaffVerify(driver).verifyPermissionOfStaff(staffRole)
                .completeVerify();
    }
}
