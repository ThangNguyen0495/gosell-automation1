import org.testng.annotations.Test;
import pages.dashboard.LoginPage;
import pages.dashboard.settings.staff_management.StaffPage;
import pages.dashboard.settings.staff_management.StaffVerify;
import utilities.mail.MailPage;
import utilities.role_matrix.RoleMatrix;

import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class StaffTest extends BaseTest {
    @Test
    public void createStaff() throws InterruptedException, IOException {

        for (int i = 0; i < 14; i ++) {
            String staffName = "staff 12910 %s".formatted(i);
            String staffMail = "staff12910x1004%s@nbobd.com".formatted(i);
            List<Integer> staffRole = List.of(i);
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

            new StaffVerify(driver).verifyPermissionOfStaff(staffRole);

            new StaffPage(driver).logoutSellerAccount();

            System.out.printf("-----END OF ROLE : %s -----%n", new RoleMatrix().staffRoleText().get(i));

        }
        new StaffVerify(driver).completeVerify();
    }
}
