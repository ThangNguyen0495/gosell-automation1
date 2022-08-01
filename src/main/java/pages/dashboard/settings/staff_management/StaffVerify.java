package pages.dashboard.settings.staff_management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StaffVerify extends StaffElement{
    WebDriverWait wait;
    public StaffVerify(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
