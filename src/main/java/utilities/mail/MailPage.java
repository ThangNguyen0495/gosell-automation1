package utilities.mail;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MailPage {
    WebDriver driver;
    WebDriverWait wait;
    MailElement element;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        element = new MailElement(driver);
    }

    public MailPage openMail(String email) throws InterruptedException {
        sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.open('%s');".formatted("https://generator.email/" + email));
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return this;
    }

    public String getPassword() {
        wait.until(ExpectedConditions.visibilityOf(element.MAIL_ELEMENT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element.MAIL_ELEMENT);
        String password = element.PASSWORD.getText();
        var tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            ((JavascriptExecutor) driver).executeScript("window.close();");
        }
        driver.switchTo().window(tabs.get(0));
        return password;
    }
}
