import org.testng.annotations.Test;
import pages.dashboard.home.HomePage;
import pages.dashboard.LoginPage;
//import pages.storefront.LoginPage;
import pages.dashboard.service.CreateServicePage;
import pages.dashboard.service.ServiceManagementPage;
import pages.storefront.HeaderSF;
import pages.storefront.ServiceDetailPage;

import java.io.IOException;

import static utilities.links.Links.*;

public class CreateServiceTest extends BaseTest{
    LoginPage login;
    HomePage home;
    ServiceManagementPage serviceManagement;
    CreateServicePage createService;
    pages.storefront.LoginPage loginSF;
    HeaderSF headerSF;
    ServiceDetailPage serviceDetailPage;
    String serviceName= "";
    String listingPrice = "";
    String sellingPrice = "";
    String description="Service description";
    String[] images={"cham-soc-mat.jpg","giam-beo-bung.jpg"};
    String[] locations={"Thu Duc", "Quan 9", "Quan 1", "Quan 2"};
    String[] timeSlots={"10:00","12:00","14:30"};
    @Test
    public void CS01_CreateService() {
        login = new LoginPage(driver);
        login.navigate().performLogin("0703618433","Psso124@");
        home =  new HomePage(driver);
        home.goToSevices();
        serviceManagement = new ServiceManagementPage(driver);
        serviceManagement.goToCreateServicePage();
        createService = new CreateServicePage(driver);
        serviceName= "Automation Service "+ generate.generateString(10);
        listingPrice = generate.generateNumber(6);
        createService.inputServiceName(serviceName)
                .inputListingPrice(listingPrice);
        sellingPrice=  createService.inputSellingPrice(listingPrice,generate.generateNumber(2));
        createService.uncheckOnShowAsListingService()
                .inputServiceDescription(description)
                .inputCollections()
                .uploadImages(images)
                .inputLocations(locations)
                .inputTimeSlots(timeSlots)
                .clickSaveBtn()
                .verifyCreateSeviceSuccessfulMessage();
   }
   @Test
    public void CS02_VerifyServiceOnSF() throws IOException {
       loginSF = new pages.storefront.LoginPage(driver);
       loginSF.navigate(SF_ShopVi);
       headerSF = new HeaderSF(driver);
       headerSF.searchWithFullName(serviceName)
               .verifySearchSuggestion(serviceName,sellingPrice)
               .clickSearchResult();
       serviceDetailPage.verifyServiceName(serviceName)
               .verifyListingPrice(listingPrice)
               .verifySellingPrice(sellingPrice);

   }

}
