import org.testng.annotations.Test;
import pages.dashboard.LoginPage;
import pages.dashboard.settings.staff_management.StaffPage;

import static java.lang.Thread.sleep;

public class StaffTest extends BaseTest{
    @Test
    public void createStaff() throws InterruptedException {
//        new LoginPage(driver).navigate()
//                .inputEmailOrPhoneNumber("stgaboned@nbobd.com")
//                .inputPassword("Abc@12345")
//                .clickLoginBtn();
//
//        sleep(3000);
//
//        new StaffPage(driver).navigate()
//                .clickOnTheAddStaffBtn()
//                .inputStaffName("Test 12345")
//                .inputStaffMail("all_role@nbobd.com")
//                .selectStaffPermission()
//                .selectBranch()
//                .clickOnTheDoneBtn();

        new LoginPage(driver).navigate()
                .switchToStaffTab()
                .inputEmailOrPhoneNumber("all_role@nbobd.com")
                .inputPassword("fsx1mkrx")
                .clickLoginBtn();
    }
}
