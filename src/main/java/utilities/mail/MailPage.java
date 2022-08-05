package utilities.mail;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MailPage extends MailElement {
    WebDriverWait wait;

    public MailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public MailPage openMail(String username) throws InterruptedException {
        sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.open('%s');".formatted("https://qa.team/" + username));
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return this;
    }

    public String getPassword(String subjectText) throws InterruptedException {
        String password = "";
        if (MAIL_ELEMENT.size() == 0) {
            sleep(3000);
            driver.navigate().refresh();
        }
        for (WebElement element : MAIL_ELEMENT) {
            if (element.getText().contains(subjectText)) {
                element.click();
                sleep(3000);
                password = PASSWORD.getText().split("Password :")[1].split("Log In at")[0];
                System.out.println(password);
                break;
            }
        }
        var tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            ((JavascriptExecutor) driver).executeScript("window.close();");
        }
        driver.switchTo().window(tabs.get(0));
        return password;
    }
}
