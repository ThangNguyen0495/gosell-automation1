import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.data.DataGenerator;
import utilities.driver.InitWebdriver;

public class BaseTest {
    WebDriver driver;
    
    DataGenerator generate;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new InitWebdriver().getDriver("chrome", "false");
        generate = new DataGenerator();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
