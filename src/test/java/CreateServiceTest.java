import org.testng.annotations.Test;
import pages.dashboard.home.HomePage;
import pages.dashboard.LoginPage;
import pages.dashboard.service.CreateServicePage;
import pages.dashboard.service.ServiceManagementPage;

public class CreateServiceTest extends BaseTest{
    LoginPage login;
    HomePage home;
    ServiceManagementPage serviceManagement;
    CreateServicePage createService;
    @Test
    public void CS01_CreateService() {
        login = new LoginPage(driver);
        login.navigate().performLogin("0703618433","Psso124@");
        home =  new HomePage(driver);
        home.goToSevices();
        serviceManagement = new ServiceManagementPage(driver);
        serviceManagement.goToCreateServicePage();
        createService = new CreateServicePage(driver);
        String listingPrice = generate.generateNumber(6);
        createService.inputServiceName("Automation Service "+ generate.generateString(10))
                .inputListingPrice(listingPrice)
                .inputSellingPrice(listingPrice,generate.generateNumber(2))
                .uncheckOnShowAsListingService()
                .inputServiceDescription("Service description")
                .inputMultipleCollection("Cham soc mat")
                .uploadImages("cham-soc-mat.jpg","giam-beo-bung.jpg")
                .inputLocations("Thu Duc", "Quan 9", "Quan 1", "Quan 2")
                .inputTimeSlots("10:00","12:00","14:30");

    }

}
