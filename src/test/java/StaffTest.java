import org.testng.annotations.Test;
import pages.dashboard.LoginPage;
import pages.dashboard.settings.staff_management.StaffPage;
import pages.dashboard.settings.staff_management.StaffVerify;
import utilities.mail.MailPage;
import utilities.role_matrix.RoleMatrix;

import java.io.IOException;
import java.util.List;

import static pages.dashboard.settings.staff_management.StaffPage.staffMail;

public class StaffTest extends BaseTest {
    @Test
    public void Tcs01_createStaff() throws InterruptedException, IOException {
        for (int i = 0; i < 1; i++) {
            String staffName = "staff Test 2022/08/05_round2 %s".formatted(i);
            String staffMail = "staff20220805r2%s@qa.team".formatted(i);
            List<Integer> staffRole = List.of(i);
            List<Integer> staffBranch = List.of(0);

            new LoginPage(driver).navigate()
                    .inputEmailOrPhoneNumber("stgauto@nbobd.com")
                    .inputPassword("Abc@12345")
                    .clickLoginBtn();

            new StaffPage(driver).waitLoginPage()
                    .navigate()
                    .clickOnTheAddStaffBtn()
                    .inputStaffName(staffName)
                    .inputStaffMail(staffMail)
                    .selectStaffPermission(staffRole)
                    .selectBranch(staffBranch)
                    .clickDoneBtn()
                    .verifyCreateStaffSuccessfully()
                    .logout();

            new LoginPage(driver).navigate()
                    .switchToStaffTab()
                    .inputEmailOrPhoneNumber(staffMail)
                    .inputPassword(new MailPage(driver).openMail(staffMail.split("@qa.team")[0]).getPassword("You have been added as staff for"))
                    .clickLoginBtn();

            new StaffPage(driver).waitLoginPage()
                    .verifyPermissionOfStaff(staffRole)
                    .logout();

            System.out.printf("-----END OF ROLE : %s -----%n", new RoleMatrix().staffRoleText().get(i));

        }
        new StaffVerify(driver).completeVerify();
    }

    @Test
    public void Tcs02_EditTest() throws IOException, InterruptedException {
        for (int i = 0; i < 15; i++) {
            String staffName = "staff Test 2022/08/05_round2 %s".formatted(i);
            List<Integer> staffRole = List.of(i);
            List<Integer> staffBranch = List.of(0);
            new LoginPage(driver).navigate()
                    .inputEmailOrPhoneNumber("stgaboned@nbobd.com")
                    .inputPassword("Abc@12345")
                    .clickLoginBtn();

            new StaffPage(driver).waitLoginPage()
                    .navigate()
                    .clickOnTheEditIcon()
                    .inputStaffName(staffName)
                    .deselectedAllStaffPermissions()
                    .selectStaffPermission(staffRole)
                    .deselectAllBranch()
                    .selectBranch(staffBranch)
                    .clickDoneBtn()
                    .verifyUpdateStaffSuccessfully()
                    .logout();

            new LoginPage(driver).navigate()
                    .switchToStaffTab()
                    .inputEmailOrPhoneNumber(staffMail)
                    .inputPassword(new MailPage(driver).openMail(staffMail).getPassword("You have been added as staff for"))
                    .clickLoginBtn();

            new StaffPage(driver).waitLoginPage()
                    .verifyPermissionOfStaff(staffRole)
                    .logout();

            System.out.printf("-----END OF ROLE : %s -----%n", new RoleMatrix().staffRoleText().get(i));

        }
        new StaffVerify(driver).completeVerify();
    }

//    @Test
//    public void DeleteStaff() throws InterruptedException, IOException {
//        new LoginPage(driver).navigate()
//                .inputEmailOrPhoneNumber("stgaboned@nbobd.com")
//                .inputPassword("Abc@12345")
//                .clickLoginBtn();
//
//        new StaffPage(driver).waitLoginPage()
//                .navigate()
//                .clickOnTheDeleteIcon();
//    }
}
